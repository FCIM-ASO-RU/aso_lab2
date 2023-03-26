package aso_lab2;

import static aso_lab2.Store.quantity;

public class Consumer extends Thread {

    private final Store store;
    private static int cons = 0;

    public Consumer(Store _store, String _name) {
        store = _store;
        setName(_name);
    }

    @Override
    public void run() {
        // Так как было сгенерировано 47 объектов то и потреблено столько же
        while(cons <= quantity){

            try {
                //ожидание пока другой поток не выполнит нужную работу
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }

            //Код выполняемый в synchronized выполняется одним объектом и этот объект держит его ключ, пока объект не отдаст ключ никто не может выполнять этот же код
            synchronized (this){
                try {
                    System.out.println("from store " + store.get()); //Потребитель потребляет два объекта
                    System.out.println("from store " + store.get());
                    cons+=2;
                    System.out.println("Consumers got " + cons);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
        System.out.println('\n'+"-->" + getName() + "  stopped");
    }

}