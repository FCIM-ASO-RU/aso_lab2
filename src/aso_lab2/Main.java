package aso_lab2;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        int var = 1;

        Producer producer1 = new Producer(store, "Producer 1");
        Producer producer2 = new Producer(store, "Producer 2");
        Producer producer3 = new Producer(store, "Producer 3");

        Consumer consumer1 = new Consumer(store, "Consumer 1");
        Consumer consumer2 = new Consumer(store, "Consumer 2");
        Consumer consumer3 = new Consumer(store, "Consumer 3");
        Consumer consumer4 = new Consumer(store, "Consumer 4");

        if (var == 1) {

            producer1.setPerfomance(2);
            producer2.setPerfomance(2);
            producer3.setPerfomance(2);

            consumer1.setPerfomance(2);
            consumer2.setPerfomance(2);
            consumer3.setPerfomance(2);
            consumer4.setPerfomance(2);

        } else if (var == 2) {

            producer1.setPerfomance(2);
            producer2.setPerfomance(2);
            producer3.setPerfomance(2);

            consumer1.setPerfomance(1);
            consumer2.setPerfomance(1);
            consumer3.setPerfomance(1);
            consumer4.setPerfomance(1);

        } else if (var == 3) {

            producer1.setPerfomance(1);
            producer2.setPerfomance(1);
            producer3.setPerfomance(1);

            consumer1.setPerfomance(2);
            consumer2.setPerfomance(2);
            consumer3.setPerfomance(2);
            consumer4.setPerfomance(2);
        }

        producer1.start();
        producer2.start();
        producer3.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }
}
