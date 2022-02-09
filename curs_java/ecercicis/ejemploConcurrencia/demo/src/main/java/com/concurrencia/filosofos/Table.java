package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.filosofos;

public class Table<E, D> {

    private final E[] data;
    private final D[] datad;

    public Table(int size) {
        data = (E[]) new Philosopher[size];
        datad = (D[]) new Fork[size];

    }

    public synchronized void take(E x, D y) {
        // System.out.println(Thread.currentThread().getName() + " -> put()!!");

        // System.out.println(Thread.currentThread().getName() + " -> notifyAll()!!");
        notifyAll();
    }

    public synchronized E leave() {
        // System.out.println(Thread.currentThread().getName() + " -> take()!!");
        while (true) {
            waiting();
        }

    }

    private void waiting() {
        try {
            // System.out.println(Thread.currentThread().getName() + " -> waiting()
            // start!!");

            wait();

            // System.out.println(Thread.currentThread().getName() + " -> waiting()
            // exit!!");
        } catch (InterruptedException ignored) {
        }
    }

}
