package Test6Threading;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    List<Integer> items;
    BlockingQueue<Integer> queueItems;

    public Consumer(List<Integer> items) {
        this.items = items;
    }

    public Consumer(BlockingQueue<Integer> queueItems) {
        this.queueItems = queueItems;
    }

    public void processItems() throws InterruptedException {
        synchronized (items) {
            if (items.size() == 0) {
                System.out.println("No items present waiting for item to be added........");
                items.wait();
            }

            System.out.println("Item processed: " + items.remove(0));
            items.notify();
        }
    }

    @Override
    public void run() {
        if (items != null) {
            while (true) {
                try {
                    processItems();
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

        if (queueItems != null) {
            while (true) {
                synchronized (this) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("Processed Item: " + queueItems.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (queueItems.isEmpty())
                    break;
            }
            System.out.println("All Questions Processed!!!!");
        }
    }
}