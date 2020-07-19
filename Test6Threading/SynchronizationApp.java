package Test6Threading;

public class SynchronizationApp {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        // so both the threads are passed same object and so will work on same inner variable 'value'
        // so as they will read same data while executing concurrently, the getNext() function within
        // sequence class contains 'synchronise' block for them to synchronize while reading same data
        Worker worker = new Worker(sequence);
        worker.start();
        Worker worker2 = new Worker(sequence);
        worker2.start();

        // with synchronised method
        SyncWorker syncWorker = new SyncWorker(sequence);
        syncWorker.start();
        SyncWorker syncWorker2 = new SyncWorker(sequence);
        syncWorker2.start();
        
    }
}

class SyncWorker extends Thread {
    private Sequence sequence;

    public SyncWorker (Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i=0; i< 100; i++) {
            System.out.println(sequence.getSynchronisedNext() + " by " + Thread.currentThread().getName());
        }
    }
}

class Worker extends Thread {

    private Sequence sequence;
    public Worker(Sequence sequence) {
        this.sequence = sequence;
    }

    @Override
    public void run() {
        for (int i=0; i< 100; i++) {
            System.out.println(sequence.getNext() + " by " + Thread.currentThread().getName());
        }
    }
}