package Test6Threading;

public class ThreadpoolRunnable implements Runnable {

    private int message;
    private String name;

    public ThreadpoolRunnable(int message, String name) {
        this.message = message;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "[RECIEVED]: " + message);
        processMessage();
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "[PROCESSED]: " + message);
        } catch (InterruptedException e) {
            System.out.println("Exception ocurred at: " + name);
        }
    }

    @Override
    public String toString() {
        return name;
    }

}