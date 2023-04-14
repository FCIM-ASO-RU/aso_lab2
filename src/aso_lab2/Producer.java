package aso_lab2;

public class Producer extends Thread {

    private final Store store;
    private int performance;
    private int producedByMe;

    public Producer(Store _store, String name) {
        store = _store;
        setName(name);
        performance = 1;
        producedByMe = 0;
    }
    public void setPerformance(int perf){
        performance = perf;
    }

    @Override
    public void run() {
        struct info;
        while (true) {
            synchronized (this) {
                info = store.put(performance);
                if (!info.error) {
                    producedByMe += performance;
                }
                System.out.printf("%s: %-18s | Produced by me: %2d | Produced by all: %2d  | Store current: %2d \n", getName() , info.message , producedByMe, info.fromAll, info.storeCurrent);

                if (info.error) {
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if ( info.stopSignal ) {
                    System.out.println(getName() + ": thread stop  | produced by me: " + producedByMe);
                    break;
                }
            }
        }
    }
}