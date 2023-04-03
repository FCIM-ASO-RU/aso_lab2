package team_a;

import java.util.Random;

public class Producer extends Thread {
    private final Store store;
    private final int number;
    private final String[] vawel;
    private final int size;

    public Producer(final Store c, final int number, final int size) {
        store = c;
        this.number = number;
        this.size = size;
        vawel = new String[]{"Lipsi HA", "Za деньги да", "KAK MOMMY", "POPSTAR", "MONEYKEN LOVE"};
    }

    @Override
    public void run() {
        final Random random = new Random();
        for (int i =0; i < size ; i++){
            final int arrayElement = random.nextInt(vawel.length);
            store.put(vawel[arrayElement]);
            System.out.println("Producer #" + number + " put: " + vawel[arrayElement]);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}