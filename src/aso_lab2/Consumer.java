package aso_lab2;

public class Consumer extends Thread {
    /* Эту хрень делает Ваня */
    private final Store store;
    
    public Consumer(final Store store, final String name) {
        this.store = store;
        setName(name);
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
    
}
