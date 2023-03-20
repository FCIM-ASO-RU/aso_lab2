package aso_lab2;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /* Create 4 producers and 3 consumers */
        final Store c = new Store();

        final Producer firstProducer = new Producer(c, 1, 3);
        final Producer thirdProducer = new Producer(c, 2, 2);
        final Producer secondProducer = new Producer(c, 3, 2);
        final Producer fourthProducer = new Producer(c, 4, 2);

        final Consumer firstConsumer = new Consumer(c, 1);
        final Consumer secondConsumer = new Consumer(c, 2);
        final Consumer thirdConsumer = new Consumer(c, 3);

        firstProducer.start();
        secondProducer.start();
        thirdProducer.start();
        fourthProducer.start();
        firstConsumer.start();
        secondConsumer.start();
        thirdConsumer.start();
        firstProducer.join();
    }
}
