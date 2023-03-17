package aso_lab2;

public class Store {
    
    private static final int capacity = 0; // указываете в соответствии с вариантом
    private int quantity;
    
    public Store() {
        quantity = 0;
    }
    
    public synchronized int get() {
        return 0; // тип данных возвращаемого значения можно изменить
    }
    
    public synchronized void put(char c) {
        
    }
    
}