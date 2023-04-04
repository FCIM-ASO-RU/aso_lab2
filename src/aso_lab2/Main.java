package aso_lab2;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        int perfProducer = 2;
        int perfConsumer = 2;

        Producer producer1 = new Producer(store, "Producer 1");
        Producer producer2 = new Producer(store, "Producer 2");
        Producer producer3 = new Producer(store, "Producer 3");

        Consumer consumer1 = new Consumer(store, "Consumer 1");
        Consumer consumer2 = new Consumer(store, "Consumer 2");
        Consumer consumer3 = new Consumer(store, "Consumer 3");
        Consumer consumer4 = new Consumer(store, "Consumer 4");

        producer1.setPerformance(perfProducer);
        producer2.setPerformance(perfProducer);
        producer3.setPerformance(perfProducer);

        consumer1.setPerformance(perfConsumer);
        consumer2.setPerformance(perfConsumer);
        consumer3.setPerformance(perfConsumer);
        consumer4.setPerformance(perfConsumer);

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}