package aso_lab2;

public class Store {
    
    private static final int CAPACITY = 3; // указываете в соответствии с вариантом
    private char number = ' ';
    private boolean available = false;
    
    public synchronized char get() {
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        available = false;
        notifyAll();
        return number;
    }
    
    public synchronized void put(char c) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        this.number = c;
        available = true;
        notifyAll();
    }
    
}