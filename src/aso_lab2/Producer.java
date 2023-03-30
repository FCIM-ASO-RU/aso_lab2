package aso_lab2;

public class Producer extends Thread {
    
    private final Store store;
    private int performance;
    
    public Producer(Store _store, String name) {
        store = _store;
        setName(name);
        performance = 1;
    }
    public void setPerfomance(int perf){
        performance = perf;
    }
    
    @Override
    public void run() {
        struct info = new struct();
        while (true) {
            info = store.put(performance);
            if (info.error) {
                try {
                    System.out.println(getName() + ": " + info.message);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else System.out.println(getName() + ": " + info.message);
            if ( info.stopSignal ) {
                break;
            }
        }
    }
    
}
