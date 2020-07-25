package Test6Threading;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private List<Integer> items;
    final private int LIMIT = 5;
    private BlockingQueue<Integer> queueItems;
    private int item;

    public Producer(List<Integer> items) {
        this.items = items;
    }

    public Producer(BlockingQueue<Integer> queueItems) {
        this.queueItems = queueItems;
    }

    public void produceItems(int item) throws InterruptedException {
        // synchronise locks an object that can not be accesed by other threads till the
        // this block finishes it's work
        // thread having synchronised on same object interact with each other for that
        // object
        // items is used as locked object as it would be shared amongst threads
        synchronized (items) {
            if (items.size() == LIMIT) {
                System.out.println("Items have piled up.............");
                items.wait();
            }

            System.out.println("Item being added: " + item);
            items.add(item);
            System.out.println("Item added notifying other threads....");
            items.notify(); // notify wakes only one random thread out of many waiting threads()
                            // but notifyAll() wakes up all waiting threads but takes more computational
                            // power
                            // but has less chance of getting into lock state as if one thread misses the
                            // notification
                            // there are others to notify it as well
        }
    }

    @Override
    public void run() {
        if (items != null) {
            for (int i = 0; i < 20; i++) {
                try {
                    produceItems(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                Thread.sleep(15000);
                produceItems(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (queueItems != null) {
            while (true) {
                synchronized(this) {
                    try {
                        queueItems.put(getNextItem());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (item == 20)
                    break;
            }
        }
    }

    private int getNextItem() {
        int itemInc = item++;
        System.out.println("Add item: " + itemInc);
        return itemInc;
    }
}