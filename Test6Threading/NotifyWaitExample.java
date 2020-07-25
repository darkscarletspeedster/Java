package Test6Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class NotifyWaitExample {
    public static void main(String[] args) {
        System.out.println("Use Method: ");
        Scanner sc = new Scanner(System.in);
        final int runMethod = sc.nextInt(); 

        if (runMethod == 1) {
            List<Integer> items = new ArrayList<>();

            Thread producer = new Thread(new Producer(items));
            Thread consumer = new Thread(new Consumer(items));
            producer.start();
            consumer.start();
        }

        // using ArrayBlockingQueue for same problem
        // it takes care of notify and wait internally
        if (runMethod == 2) {
            BlockingQueue<Integer> queueItems = new ArrayBlockingQueue<>(5);

            Thread producer = new Thread(new Producer(queueItems));
            Thread consumer = new Thread(new Consumer(queueItems));
            producer.start();
            consumer.start();
        }

        sc.close();
    }
}