package Test6Threading;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(2);

        ThreadpoolRunnable threadpoolRunnable = new ThreadpoolRunnable(1, "Task 1");
        service.execute(threadpoolRunnable);

        ThreadpoolRunnable threadpoolRunnable2 = new ThreadpoolRunnable(2, "Task 2");
        service.execute(threadpoolRunnable2);

        ThreadpoolRunnable threadpoolRunnable3 = new ThreadpoolRunnable(3, "Task 3");
        service.execute(threadpoolRunnable3);

        ThreadpoolRunnable threadpoolRunnable4 = new ThreadpoolRunnable(4, "Task 4");
        service.execute(threadpoolRunnable4);

        // if not called program will stay on as service will wait for tasks
        // so by calling this service smoothly close out
        service.shutdown();

        /* Thread.sleep(2000);
        
        // shut downs the service immediately, no matter if task present to be executed
        List<Runnable> notExecutedTask = service.shutdownNow();
        for (int i = 0; i < notExecutedTask.size(); i++)
            System.out.println("Task not Executed: " + notExecutedTask.get(i)); */

        // waits for given time to terminate the service
        // or if service already terminated before moving forward in main thread
        boolean timedOut =  service.awaitTermination(4, TimeUnit.SECONDS);
        System.out.println(timedOut ? "Service Already Terminated" : "Time Out, moving Forward!!!!!");

        while(!service.isTerminated()) {
            // will not let main thread excute any further
            // unless service has been shut down
        }

        System.out.println("Service was shut down!!!");

    }
}