package team_e;

public class PruteanProducer extends Thread {
    private final PruteanStore store;
    private final Object objectTypeLock = new Object();

    
    public PruteanProducer(PruteanStore _store, String name) {
        store = _store;
        setName(name);
    }
    
    @Override
    public void run() {
        int goodsProduced = 0;

        while (goodsProduced < store.getQuantity())
        {
            synchronized (objectTypeLock)
            {
                if (!store.isFullStore())
                {
                    int goodOne = (int) (Math.random() * 50) * 2;
                    int goodTwo = (int) (Math.random() * 50) * 2;

                    store.put(goodOne);
                    store.put(goodTwo);

                    goodsProduced += 2;

                    System.out.println(getName() + ": Produced goods " + goodOne + " and " + goodTwo);

                    if (store.isFullStore()) {
                        System.out.println(getName() + ": Store is full");
                    }
                }
            }
        }
    }
}