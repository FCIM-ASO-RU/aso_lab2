package aso_lab2;

class struct{
    public boolean error;
    public String message;
    public boolean stopSignal;
    public struct(){
        error = false;
        message = "";
        stopSignal = false;
    }
}
public class Store { //by Prisacari
    private static final int Z = 19; // обьем продуктов
    private static final int capacity = 5; // обьем склада
    private int quantity; // склад
    private int countAdd;
    private int countRemove;
    private boolean stopSignalProducer;
    private boolean stopSignalConsumer;
    public Store() {
        quantity = 0;
        countAdd = 0;
        countRemove = 0;
        stopSignalProducer = false;
        stopSignalConsumer = false;
    }
    
    public synchronized struct get(int perf) {
        struct get_out = new struct();
        if( (quantity - perf >= 0) && !stopSignalConsumer) {
            quantity-=perf;
            countRemove += perf;
            get_out.message += "get from Store, ";
        } else {
            get_out.error = true;
            get_out.message += "store is empty, ";
        }
        if (countRemove > Z) {
            stopSignalConsumer = true;
        }
        get_out.stopSignal = stopSignalConsumer;
        get_out.message += "store current: " + Integer.toString(quantity) + ", ";
        get_out.message += "oborot: " + Integer.toString(countRemove) + ".";
        return get_out;
    }
    
    public synchronized struct put(int perf) {
        struct put_out = new struct();
        if( (quantity + perf <= capacity) && !stopSignalProducer ) {
            quantity+=perf;
            countAdd += perf;
            put_out.message += "put to Store, ";
        } else {
            put_out.error = true;
            put_out.message += "store is overflow, ";
        }
        if (countAdd > Z) {
            stopSignalProducer = true;
        }
        put_out.stopSignal = stopSignalProducer;
        put_out.message += "store current: " + Integer.toString(quantity) + ", ";
        put_out.message += "oborot: " + Integer.toString(countAdd) + ".";
        return put_out;
    }

    
}