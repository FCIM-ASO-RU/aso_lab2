package aso_lab2;

class struct{
    public boolean error;
    public String message;
    public struct(){
        error = false;
        message = "";
    }
}
public class Store { //by Prisacari
    
    private static final int capacity = 5; // обьем склада
    private int quantity; // склад
    
    public Store() {
        quantity = 0;
    }
    
    public synchronized struct get() {
        struct get_out = new struct();
        if( quantity - 1 >= 0 ) {
            quantity-=1;
            get_out.message += "Get from Store, ";
        } else {
            get_out.error = true;
            get_out.message += "Store is empty, ";
        }
        get_out.message += "store current: " + Integer.toString(quantity) + ".";
        return get_out;
    }
    
    public synchronized struct put() {
        struct put_out = new struct();
        if( quantity + 1 <= capacity ) {
            quantity+=1;
            put_out.message += "Put to Store, ";
        } else {
            put_out.error = true;
            put_out.message += "Store is overflow, ";
        }
        put_out.message += "store current: " + Integer.toString(quantity) + ".";
        return put_out;
    }
    
}