package aso_lab2;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();

        Producer producer1 = new Producer(store, "Producer 1");
        Producer producer2 = new Producer(store, "Producer 2");
        Producer producer3 = new Producer(store, "Producer 3");
        producer1.start();
        producer2.start();
        producer3.start();

        Consumer consumer1 = new Consumer(store, "Consumer 1");
        Consumer consumer2 = new Consumer(store, "Consumer 2");
        Consumer consumer3 = new Consumer(store, "Consumer 3");
        Consumer consumer4 = new Consumer(store, "Consumer 4");
        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}
