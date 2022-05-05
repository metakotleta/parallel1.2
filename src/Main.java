import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(PROCESSORS);
        List<MyThread> threadList = new ArrayList<>();

        for (int i = 0; i < PROCESSORS; i++) {
            threadList.add(new MyThread("MyThread-" + i).setSleepTime((i+1)*100).setCycles(i*i));
        }

        List<Future<ThreadResult>> futureList = executorService.invokeAll(threadList);

        for (Future<ThreadResult> future: futureList) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
