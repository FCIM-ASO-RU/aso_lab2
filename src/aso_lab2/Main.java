package aso_lab2;

public class Main {
    static void about() {
        System.out.println("FCIM ASO RU LAB 2");
        System.out.println();
        System.out.println("Done by:");
        System.out.println("Team A - Chiurcciu Ivan, Coşneanu Valeriu, Gaşimov Ramin");
        System.out.println("Team B - Fiodorov Vladimir, Malanciuc Dmitri, Prisacari Serghei");
        System.out.println("Team C - Gribencicov Maxim, Homenschi Valentin, Marcova Jasmina");
        System.out.println("Team D - Melnic Dmitri, Şveţ Vadim, Tomaşciuc Iaroslav");
        System.out.println("Team E - Neer Ecaterina, Prutean Stanislav");
        System.out.println("Team F - Bulat Alexandr, Dubovîi Mihail, Patraşco Serghei");
        System.out.println();
        System.out.println("Use launch arguments to run their code (e.g. Main -a)");
    }
    
    public static void main(String[] args) {
        if(args.length>0)
            switch(args[0]) {
                case "-a":  // Team A - Chiurcciu Ivan, Coşneanu Valeriu, Gaşimov Ramin
                    try {
                        /* Create 4 producers and 3 consumers */
                        team_a.Store c = new team_a.Store();
                        
                        team_a.Producer firstProducer = new team_a.Producer(c, 1, 3);
                        team_a.Producer thirdProducer = new team_a.Producer(c, 2, 2);
                        team_a.Producer secondProducer = new team_a.Producer(c, 3, 2);
                        team_a.Producer fourthProducer = new team_a.Producer(c, 4, 2);
                        
                        team_a.Consumer firstConsumer = new team_a.Consumer(c, 1);
                        team_a.Consumer secondConsumer = new team_a.Consumer(c, 2);
                        team_a.Consumer thirdConsumer = new team_a.Consumer(c, 3);
                        
                        firstProducer.start();
                        secondProducer.start();
                        thirdProducer.start();
                        fourthProducer.start();
                        firstConsumer.start();
                        secondConsumer.start();
                        thirdConsumer.start();
                        firstProducer.join();
                    }
                    catch(InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case "-b":  // Team B - Fiodorov Vladimir, Malanciuc Dmitri, Prisacari Serghei
                    int var = 1;
                    
                    team_b.Store store_b = new team_b.Store();
                    
                    team_b.Producer producerB1 = new team_b.Producer(store_b, "Producer 1");
                    team_b.Producer producerB2 = new team_b.Producer(store_b, "Producer 2");
                    team_b.Producer producerB3 = new team_b.Producer(store_b, "Producer 3");
                    
                    team_b.Consumer consumerB1 = new team_b.Consumer(store_b, "Consumer 1");
                    team_b.Consumer consumerB2 = new team_b.Consumer(store_b, "Consumer 2");
                    team_b.Consumer consumerB3 = new team_b.Consumer(store_b, "Consumer 3");
                    team_b.Consumer consumerB4 = new team_b.Consumer(store_b, "Consumer 4");
                    
                    if(args.length>1)
                        try {
                            var = Integer.valueOf(args[1]);
                        }
                        catch(NumberFormatException ex) {
                            System.out.println("Please enter a valid integer into second argument.");
                        }
                    
                    switch(var) {
                        case 2:
                            producerB1.setPerformance(2);
                            producerB2.setPerformance(2);
                            producerB3.setPerformance(2);
                            consumerB1.setPerformance(1);
                            consumerB2.setPerformance(1);
                            consumerB3.setPerformance(1);
                            consumerB4.setPerformance(1);
                            break;
                        case 3:
                            producerB1.setPerformance(1);
                            producerB2.setPerformance(1);
                            producerB3.setPerformance(1);
                            consumerB1.setPerformance(2);
                            consumerB2.setPerformance(2);
                            consumerB3.setPerformance(2);
                            consumerB4.setPerformance(2);
                            break;
                        default:
                            producerB1.setPerformance(2);
                            producerB2.setPerformance(2);
                            producerB3.setPerformance(2);
                            consumerB1.setPerformance(2);
                            consumerB2.setPerformance(2);
                            consumerB3.setPerformance(2);
                            consumerB4.setPerformance(2);
                    }
                    
                    producerB1.start();
                    producerB2.start();
                    producerB3.start();
                    consumerB1.start();
                    consumerB2.start();
                    consumerB3.start();
                    consumerB4.start();
                    break;
                case "-c":  // Team C - Gribencicov Maxim, Homenschi Valentin, Marcova Jasmina
                    team_c.Store store_c = new team_c.Store();
                    
                    team_c.Producer firstProducer = new team_c.Producer(store_c, "1");
                    team_c.Producer thirdProducer = new team_c.Producer(store_c,"2");
                    
                    team_c.Consumer consumer = new team_c.Consumer(store_c,1);
                    
                    firstProducer.start();
                    thirdProducer.start();
                    consumer.start();
                    break;
                case "-d":  // Team D - Melnic Dmitri, Şveţ Vadim, Tomaşciuc Iaroslav
                    team_d.Store store_d = new team_d.Store();

                    team_d.Producer FProducer = new team_d.Producer(store_d, "one");
                    team_d.Producer THProducer = new team_d.Producer(store_d,"two");

                    team_d.Consumer cons = new team_d.Consumer(store_d,1);

                    FProducer.start();
                    THProducer.start();
                    cons.start();
                    break;
                case "-e":  // Team E - Neer Ecaterina, Prutean Stanislav
                    team_e.PruteanStore store_e = new team_e.PruteanStore();
                    
                    for (int i = 1; i < 3; i++) {
                        Thread producerThread = new Thread(new team_e.PruteanProducer(store_e, "Prutean Stanislav: Producer" + i));
                        producerThread.start();
                    }
                    
                    for (int i = 1; i < 6; i++) {
                        Thread consumerThread = new Thread(new team_e.PruteanConsumer(store_e, "Prutean Stanislav: Consumer" + i));
                        consumerThread.start();
                    }
                    
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        
                        final boolean producersComplete = Thread.getAllStackTraces().keySet().stream()
                                .filter(t -> t.getName().startsWith("Producer"))
                                .noneMatch(Thread::isAlive);

                        final boolean consumersComplete = Thread.getAllStackTraces().keySet().stream()
                                .filter(t -> t.getName().startsWith("Consumer"))
                                .noneMatch(Thread::isAlive);

                        if (producersComplete && consumersComplete) {
                            System.out.println("All producers and consumers have finished.");
                            break;
                        }
                    }
                    break;
                case "-f":  // Team F - Bulat Alexandr, Dubovîi Mihail, Patraşco Serghei
                    //Создаем объект Магазина
                    team_f.Store store_f = new team_f.Store(47);
                    
                    //По заданию два производителя и их наименования
                    team_f.Producer producerF1 = new team_f.Producer(store_f, "aso_lab2.Producer-1");
                    team_f.Producer producerF2 = new team_f.Producer(store_f, "aso_lab2.Producer-2");
                    
                    //По заданию 4 потребителя
                    team_f.Consumer consumerF1 = new team_f.Consumer(store_f, "Consumer-1");
                    team_f.Consumer consumerF2 = new team_f.Consumer(store_f, "Consumer-2");
                    team_f.Consumer consumerF3 = new team_f.Consumer(store_f, "Consumer-3");
                    team_f.Consumer consumerF4 = new team_f.Consumer(store_f, "Consumer-4");
                    
                    //Thread class имеет метод start, который запускает в отдельном потоке код написанный в методе run
                    producerF1.start();
                    producerF2.start();
                    consumerF1.start();
                    consumerF2.start();
                    consumerF3.start();
                    consumerF4.start();
                    break;
                default:
                    about();
            }
        else
            about();
    }
}