package executor.executorservice;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NetworkService implements Runnable {
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void run() {
        try {
            for (; ; ) {
                pool.execute(new Handler(serverSocket.accept()));
            }
        } catch (IOException e) {
            pool.shutdown();
        }
    }

    void shutdownAndAwaitTermination(ExecutorService service) {
        service.shutdown();
        try {
            // Wait a while for existing tasks to terminate
            if (!service.awaitTermination(60, TimeUnit.SECONDS)) {
                service.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!service.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("Pool did not terminate");
            }
        } catch (InterruptedException ie) {
            // (Re-)Cancel if current thread also interrupted
            pool.shutdownNow();
            // Preserve interrupt status
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        try {
            NetworkService networkService = new NetworkService(10086, 4);
            new Thread(networkService).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
