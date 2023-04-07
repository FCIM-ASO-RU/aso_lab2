package team_a;

public class Store {
    /**
     * Song that we store
     */
    private String song = "";
    /**
     * Boolean shows if is available to get song
     */
    private boolean available = false;

    /**
     * Get one product from Store
     * @return one product from Store
     */
    public synchronized String get() { // тип данных возвращаемого значения можно изменить
        while (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        available = false;
        notifyAll();
        return song;
    }

    /**
     * Put one product to Store
     * @param songName add song to Store
     */
    public synchronized void put(final String songName) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.song = songName;
        available = true;
        notifyAll();
    }
}