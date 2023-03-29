package aso_lab2;

public class Main {

    public static void main(String[] args) {
        Store store = new Store();
        Producer firstProducer = new Producer(store, "1");
        Producer thirdProducer = new Producer(store,"2");

        Consumer consumer = new Consumer(store,1);

        firstProducer.start();
        thirdProducer.start();

        consumer.start();
    }
    
}
