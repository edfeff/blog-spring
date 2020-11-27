package rabbitmq.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class MockContext {

    private Connection connection;
    private String msg;


    public static void main(String[] args) throws Exception {
        MockContext mockContext = new MockContext();
        mockContext.start();
    }


    private void start() throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException {
        readContextJson();

        ConnectionFactory factory = new ConnectionFactory();

//        factory.setUri("amqp://guest:guest@localhost:5672/%2F");
//        或
        factory.setUri("amqp://guest:guest@localhost:5672/");
        factory.setVirtualHost("/");

        connection = factory.newConnection();

        Channel channel = connection.createChannel();

        for (int i = 0; i < 10; i++) {
            channel.basicPublish("", "demo", null, msg.getBytes());
        }
        channel.close();
        connection.close();

    }

    public void readContextJson() throws IOException {
        InputStreamReader streamReader = new InputStreamReader(HelloRabbitMq.class.getResourceAsStream("context.json"));
        BufferedReader reader = new BufferedReader(streamReader);
        String line = null;
        StringBuilder sb = new StringBuilder();
        while (null != (line = reader.readLine())) {
            sb.append(line);
        }
        reader.close();
        msg = sb.toString();
    }
}
