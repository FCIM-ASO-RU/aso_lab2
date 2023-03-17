package aso_lab2;

public class Store { //by Prisacari
    
    private static final int capacity = 0; // указываете в соответствии с вариантом
    private int quantity;
    
    public Store() {
        quantity = 0;
    }
    
    public synchronized int get() {
        if( quantity - 1 < 0 ) {
            quantity-=1;
        }
        return quantity; // type int
    }
    
    public synchronized void put() {
        if( quantity + 1 > capacity ) {
            quantity+=1;
        } else System.out.println("Store is overflow");
    }
    
}