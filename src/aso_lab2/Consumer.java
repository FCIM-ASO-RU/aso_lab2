package aso_lab2;

public class Consumer extends Thread {
    
    private final Store store;
    
    public Consumer(Store _store, String name) {
        store = _store;
        setName(name);
    }
    
    @Override
    public void run() {
        
    }
    
}
