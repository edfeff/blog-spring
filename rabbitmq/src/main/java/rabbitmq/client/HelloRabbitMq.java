package rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * <pre>
 *
 *                                    -------------------------------------------------------------------------------+
 *                                    |                                                                               |
 *                                    |                                                                               |
 *                                    |                                                             +---------------+ |
 *                                    |                                                             |               | |
 *                                    |                                                             |   queue 1     | |
 *                                    |                                                             |               | |
 *                                    +   RouteKey                  Exchange                        +------^--------+ |
 * +-----------------+   ConnectionFactory                                                             bandingkey 1   |
 * |                 |                |  +-----------+           +-------------------+                     |          |
 * | producer        +---------------->  |           |           |                   +---------------------+          |
 * |                 |      Channel   |  |           +---------->+                   |                     |          |
 * +-----------------+                |  +-----------+           +-------------------+                   bandingkey 2 |
 *                                    |                                                                    |          |
 *                                    |                                                                    |          |
 *                                    |                                                            +-------v--------+ |
 *                                    |                                                            |                | |
 *                                    |                                                            |     queue 2    | |
 *                                    |                                                            |                | |
 *                                    |                                                            +----------------+ |
 *                                    |                                                                               |
 *                                    +-------------------------------------------------------------------------------+
 * </pre>
 */
public class HelloRabbitMq {
    public static void main(String[] args) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException, InterruptedException {
        simpleSend();
        simpleReceived();
    }

    private static void simpleReceived() throws IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        factory.setVirtualHost("/");

        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
//        channel.queueDeclare("demo", true, false, false, null);
        channel.basicConsume("demo", false, "", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(envelope.getRoutingKey());
                System.out.println(properties);
                System.out.println(new String(body, "UTF-8"));
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        });
        Thread.sleep(1000);
        channel.close();
        connection.close();
    }

    public static String readContextJson() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(HelloRabbitMq.class.getResourceAsStream("context.json"));
        BufferedReader reader = new BufferedReader(streamReader);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while (null != (line = reader.readLine())) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }

    private static void simpleSend() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        factory.setVirtualHost("/");
//        factory.setUri("amqp://guest:guest@localhost:5672/");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("demo", true, false, false, null);

        String msg = readContextJson();

        channel.basicPublish("", "demo", null, msg.getBytes());

        channel.close();
        connection.close();
    }
}
