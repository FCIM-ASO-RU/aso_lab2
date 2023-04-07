package team_d;



public class Producer extends Thread {
    private final team_d.Store store;

    private int number;

    private final char[] array;

    public Producer(Store _store, String name) {
        store = _store;
        setName(name);
        array = new char[]{'b','c','d','f','g'};
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