package Test6Threading;

public class Application {
    public static void main(String[] args) {
        Task task1 = new Task("First Thread");
        task1.start();
        Task task2 = new Task("Second Thread");
        task2.start();

        // this runs on main thread and executes sequentiatlly as new thread is created
        // to run it
        // if it's setName for thread is not called we can see Thread name to be coming
        // 'main'
        RunnableTask runnableTask = new RunnableTask("Run 1");
        runnableTask.run();

        // thus we create a thread, this will now run in new thread
        Thread thread = new Thread(new RunnableTask("Run 2"));
        thread.start();

        // by annonymous class
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Annonymous");
                for (int i = 0; i < 20; i++) {
                    System.out.println("Num: " + i + " by " + Thread.currentThread().getName());
                }
            }
        });
        thread2.start();
    }
}