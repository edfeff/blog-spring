package join;


public class JoinSample {
    static class Task implements Runnable {
        int num;

        public Task(int num) {
            this.num = num;
        }

        @Override
        public void run() {
            System.out.println(num + " " + System.currentTimeMillis());
            try {
                Thread.sleep(num * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num + " " + System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task(1));
        Thread t2 = new Thread(new Task(2));
        Thread t3 = new Thread(new Task(3));

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }
}
