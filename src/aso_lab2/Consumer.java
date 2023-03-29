package aso_lab2;

public class Consumer extends Thread {
    
    private final Store store;

    private int number;

    public Consumer(Store _store, String name) {
        store = _store;
        setName(name);
    }
    public Consumer(Store store, int number) {
        this.store = store;
        this.number = number;
    }
    public void run() {
        char value = 0;
        for (int i = 0; i < 4; i++) {
            value = store.get();
            System.out.println("Consumer #" +
                    this.number + " got: " + value);
        }

    }
    
}
