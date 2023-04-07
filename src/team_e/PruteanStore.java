package team_e;

import java.util.ArrayList;

public class PruteanStore {
    private static final int capacity = 12;
    private static final int quantity = 51;
    private final ArrayList<Integer> warehouse;

    public PruteanStore() {
        warehouse = new ArrayList<>();
    }

    public synchronized int get() {
        int number = warehouse.get(0);
        warehouse.remove(0);
        return number;
    }

    public synchronized void put(int number) {
        warehouse.add(number);
    }

    public synchronized boolean isEmptyStore() {
        return warehouse.isEmpty();
    }

    public synchronized boolean isFullStore() {
        return warehouse.size() == capacity;
    }

    public synchronized int getQuantity() {
        return quantity;
    }
}