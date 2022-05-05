public class ThreadResult {
    private int value;
    private String threadName;

    public ThreadResult(int value, String threadName) {
        this.value = value;
        this.threadName = threadName;
    }

    @Override
    public String toString() {
        return "Thread: " + threadName + ", result: " + value;
    }
}
