package aso_lab2;

public class Consumer extends Thread{
    private final Store store;
    private final int number;
    public Consumer(final Store c, final int number) {
        store = c;
        this.number = number;
    }
    public void run() {
        String value = " ";
        for (int i = 0; i < 3; i++) {
            value = store.get();
            System.out.println("Consumer #" + this.number + " got: " + value);
        }
    }

}