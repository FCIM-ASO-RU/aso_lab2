package team_f;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Store {
    static final int quantity = 47;
    ArrayBlockingQueue<String> queue;

    public Store(int quantity) {
        this.queue = new ArrayBlockingQueue<>(quantity);
    }

    public void put(int oddNumber) {
        queue.add(Integer.toString(oddNumber));
    }

    public String get() throws InterruptedException {
        String element = null;
        while (element == null) {
            element = queue.poll(1, TimeUnit.SECONDS);
        }

        return element;
    }
}