package team_d;

public class Store {
    private char num = ' ';
    private boolean isworking = false;

    public synchronized char get() {
        while (!isworking) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        isworking = false;
        notifyAll();
        return num;
    }

    public synchronized void put(char c) {
        while (isworking) {
            try {
                wait();
            } catch (InterruptedException e) { }
        }
        this.num = c;
        isworking = true;
        notifyAll();
    }
}