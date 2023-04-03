package team_b;

public class Producer extends Thread {
    private final Store store;
    private int performance;
    
    public Producer(Store _store, String name) {
        store = _store;
        setName(name);
        performance = 1;
    }
    
    public void setPerformance(int perf){
        performance = perf;
    }
    
    @Override
    public void run() {
        struct info;
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