import java.util.concurrent.Callable;

public class MyThread implements Callable<ThreadResult> {

    private int sleepTime;
    private int cycle;

    public MyThread(String name) {
        Thread.currentThread().setName(name);
    }

    public MyThread setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
        return this;
    }

    public MyThread setCycles(int cycle) {
        this.cycle = cycle;
        return this;
    }

    @Override
    public ThreadResult call() throws Exception {
        int i;
        for (i = 0; i < cycle; i++) {
            System.out.println(Thread.currentThread().getName() + ": Message " + i);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + ": Cannot sleep, cause interrupted");
                Thread.currentThread().interrupt();
            }
        }
        return new ThreadResult(i, Thread.currentThread().getName());
    }

}
