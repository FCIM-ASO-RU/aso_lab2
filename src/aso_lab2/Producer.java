package aso_lab2;

public class Producer extends Thread {
    
    private final Store store;

    private int number;

    private char[] array;
    
    public Producer(Store _store, String name) {
        store = _store;
        setName(name);
        array = new char[]{'a', 'e', 'i', 'u', 'o'};
    }
    
    @Override
    public void run() {

        for (int i = 0; i <2; i++) {
            store.put(array[i]);
            System.out.println("Producer #" +
                    this.number + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
    
}
