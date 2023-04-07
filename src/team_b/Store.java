package team_b;

public class Store {
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
            get_out.message = "get from store";
        } else {
            get_out.error = true;
            get_out.message = "store is empty";
        }
        if (countRemove >= Z) {
            stopSignalConsumer = true;
        }

        get_out.stopSignal = stopSignalConsumer;
        get_out.storeCurrent = quantity;
        get_out.fromAll = countRemove;
        return get_out;
    }
    
    public synchronized struct put(int perf) {
        struct put_out = new struct();
        if( (quantity + perf <= capacity) && !stopSignalProducer ) {
            quantity+=perf;
            countAdd += perf;
            put_out.message = "put to store";
        } else {
            put_out.error = true;
            put_out.message = "store is overflow";
        }
        if (countAdd >= Z) {
            stopSignalProducer = true;
        }
        put_out.stopSignal = stopSignalProducer;
        put_out.storeCurrent = quantity;
        put_out.fromAll = countAdd;
        return put_out;
    }
}