package Test6Threading;

public class Task extends Thread {
    private String threadName;
    public Task(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(threadName);
        for (int i = 0; i < 20; i++) {
            System.out.println("Num: " + i + " by " + Thread.currentThread().getName());
        }
    }
}