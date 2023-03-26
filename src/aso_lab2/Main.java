package aso_lab2;

public class Main {

    public static void main(String[] args) {
        //Создаем объект Магазина
        Store store = new Store(47);
        //По заданию два производителя и их наименования
        Producer producer1 = new Producer(store, "aso_lab2.Producer-1");
        Producer producer2 = new Producer(store, "aso_lab2.Producer-2");

        //По заданию 4 потребителя
        Consumer consumer1 = new Consumer(store, "Consumer-1");
        Consumer consumer2 = new Consumer(store, "Consumer-2");
        Consumer consumer3 = new Consumer(store, "Consumer-3");
        Consumer consumer4 = new Consumer(store, "Consumer-4");

        //Thread class имеет метод start, который запускает в отдельном потоке код написанный в методе run
        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();
        consumer4.start();
    }

}