package Test6Threading;

import java.util.List;

public class Consumer implements Runnable {
    List<Integer> items;

    public Consumer(List<Integer> items) {
        this.items = items;
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
        while (true) {
            try {
                processItems();
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}