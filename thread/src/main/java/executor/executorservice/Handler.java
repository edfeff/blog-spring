package executor.executorservice;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class Handler implements Runnable {
    final Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //TODO
        if (socket != null || !socket.isClosed()) {
            try {
                byte[] bytes = new byte[1024 * 8];
                BufferedInputStream bufIn = new BufferedInputStream(socket.getInputStream());
                int read = bufIn.read(bytes);
                System.out.println(read);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
