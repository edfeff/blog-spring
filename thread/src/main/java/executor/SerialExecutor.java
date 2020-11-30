package executor;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;


/**
 * 序列执行器
 *
 * @author wpp
 */
public class SerialExecutor implements Executor {
    final Queue<Runnable> tasks = new ArrayDeque<>();
    final Executor delegate;
    Runnable active;

    public SerialExecutor(Executor executor) {
        this.delegate = executor;
    }

    @Override
    public synchronized void execute(Runnable command) {
        tasks.offer(new Runnable() {
            @Override
            public void run() {
                try {
                    command.run();
                } finally {
                    next();
                }
            }
        });
        if (active == null) {
            next();
        }
    }

    private synchronized void next() {
        if ((active = tasks.poll()) != null) {
            delegate.execute(active);
        }
    }

    public static void main(String[] args) {
        SerialExecutor executor = new SerialExecutor(new DirectExecutor());

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(System.currentTimeMillis());
                }
            });
        }

    }
}
