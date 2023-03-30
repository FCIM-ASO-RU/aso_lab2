package aso_lab2;

public class Consumer extends Thread {

    private final Store store;
    private int performance;
    private int consumedByMe;
    public Consumer(Store _store, String name) {
        store = _store;
        setName(name);
        performance = 1;
        consumedByMe = 0;
    }
    public void setPerformance(int perf){
        performance = perf;
    }

    @Override
    public void run() {
        struct info;
        while (true) {
            synchronized (this) {
                info = store.get(performance);
                if (!info.error) {
                    consumedByMe += performance;
                }

                System.out.printf("%s: %-18s | Consumed by me: %2d | Consumed by all: %2d  | Store current: %2d \n", getName() , info.message , consumedByMe, info.fromAll, info.storeCurrent);

                if (info.error) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if ( info.stopSignal ) {
                    System.out.println(getName() + ": thread stop | consumed by me: " + consumedByMe);
                    break;
                }
            }
        }
    }

}