package aso_lab2;

public class Producer extends Thread {
    /* Эту хрень делает Рамин */

    private final Store store;
    
    public Producer(final Store store,final String name) {
        this.store = store;
        setName(name);
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
    
}
