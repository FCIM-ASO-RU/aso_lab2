package aso_lab2;

public class Producer extends Thread {
    
    private final Store store;
    
    public Producer(Store _store, String name) {
        store = _store;
        setName(name);
    }
    
    @Override
    public void run() {
        
    }
    
}
