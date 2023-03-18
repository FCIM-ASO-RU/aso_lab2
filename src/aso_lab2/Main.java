package aso_lab2;

import TeamE.PruteanConsumer;
import TeamE.PruteanProducer;
import TeamE.PruteanStore;

public class Main {

    public static void main(String[] args) {
        PruteanStore store = new PruteanStore();

        for (int i = 1; i < 3; i++) {
            Thread producerThread = new Thread(new PruteanProducer(store, "Prutean Stanislav: Producer" + i));
            producerThread.start();
        }

        for (int i = 1; i < 6; i++) {
            Thread consumerThread = new Thread(new PruteanConsumer(store, "Prutean Stanislav: Consumer" + i));
            consumerThread.start();
        }

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            final boolean producersComplete = Thread.getAllStackTraces().keySet().stream()
                    .filter(t -> t.getName().startsWith("Producer"))
                    .noneMatch(Thread::isAlive);

            final boolean consumersComplete = Thread.getAllStackTraces().keySet().stream()
                    .filter(t -> t.getName().startsWith("Consumer"))
                    .noneMatch(Thread::isAlive);

            if (producersComplete && consumersComplete) {
                System.out.println("All producers and consumers have finished.");
                break;
            }
        }
    }
}
