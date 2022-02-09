package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.filosofos;

public class Table {

    public synchronized void take(Fork left, Fork right) {
        // System.out.println(Thread.currentThread().getName() + " -> put()!!");
        while (true) {
            waiting();
            // System.out.println(Thread.currentThread().getName() + " -> notifyAll()!!");

        }
    }

    public synchronized void leave() {
        // System.out.println(Thread.currentThread().getName() + " -> take()!!");

        notifyAll();
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
