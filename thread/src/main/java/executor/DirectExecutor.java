package executor;

import java.util.concurrent.Executor;

/**
 * 直接执行器
 *
 * @author wpp
 */
public class DirectExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        DirectExecutor executor = new DirectExecutor();

        for (int i = 0; i < 10; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
                }
            });
        }
    }
}
