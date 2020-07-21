package Test6Threading;

import java.util.ArrayList;
import java.util.List;

public class NotifyWaitExample {
    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();

        Thread producer = new Thread(new Producer(items));
        Thread consumer = new Thread(new Consumer(items));
        producer.start();
        consumer.start();
    }
}