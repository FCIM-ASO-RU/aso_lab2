package team_e;

public class PruteanConsumer extends Thread {
    private final PruteanStore store;
    private final Object objectTypeLock = new Object();

    public PruteanConsumer(PruteanStore _store, String name) {
        store = _store;
        setName(name);
    }
    
    @Override
    public void run() {
        int goodsConsumed = 0;
        while(goodsConsumed < store.getQuantity())
        {
            synchronized (objectTypeLock)
            {
                if (!store.isEmptyStore())
                {
                    int good = store.get();
                    goodsConsumed++;
                    System.out.println(getName() + ": Consumed good - " + good);

                    if (store.isEmptyStore()) {
                        System.out.println(getName() + ": Store is empty");
                    }
                }
                else
                {
                    try
                    {
                        Thread.sleep(100);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}