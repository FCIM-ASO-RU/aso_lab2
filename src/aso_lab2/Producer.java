package aso_lab2;

import java.util.Random;

import static aso_lab2.Store.quantity;

// Наследуюясь от класса Thread мы получаем возможность переписать код в методе run и запустить его в новом потоке через start
public class Producer extends Thread {

    private final Store store;

    // Библиотека рандо используется для генерирования нечетных чисел
    private final static Random random = new Random();

    //Статическая переменная a.k.a одна на все объекты, которая определяет количество созданных объектов в данно мслучае
    private static int pro = 0;

    public Producer(Store _store, String _name) {
        store = _store;
        //Метод Thread класса которые позволяет переиминовать поток в человеческое название
        setName(_name);
    }

    @Override
    public void run() {
        // По заданию сгенерировано должно быть не более 47 нечетных чисел
        while (pro <= quantity) {

            try {
                //ожидание пока другой поток не выполнит нужную работу
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            //Код выполняемый в synchronized выполняется одним объектом и этот объект держит его ключ, пока объект не отдаст ключ никто не может выполнять этот же код
            synchronized (this) {
                int oddNumber1 = random.nextInt(50) * 2 + 1; //формула нечетных чисел, рандомное число в пределах 50
                int oddNumber2 = random.nextInt(50) * 2 + 1;
                store.put(getName(), oddNumber1); // у нас один поставщик делает два ообъекта
                store.put(getName(), oddNumber2);
                pro+=2; // pro = pro + 2 та же запись
                System.out.println("Producers put " + pro);
            }

        }
        System.out.println("-->" + getName() + "  stopped");
    }

}
