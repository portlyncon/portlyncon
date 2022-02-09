/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.folosofosComprovado;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Philosopher extends Thread {
    public enum Status {
        THINKING, HUNGRY, EATING
    }

    private Table table;
    private Fork left, right;
    private Status status = Status.THINKING;

    public Philosopher(Table table, Fork left, Fork right) {
        this.table = table;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        while (true) {
            this.status = Status.THINKING;
            System.out.println(this);
            randomSleep();

            this.status = Status.HUNGRY;
            System.out.println(this);

            table.take(left, right);
            this.status = Status.EATING;
            System.out.println(this);

            randomSleep();
            table.leave(left, right);

        }
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName() + " -> is " + this.status;
    }

    public static void randomSleep() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(1, 4) * 1000);

        } catch (InterruptedException ex) {
            // Logger.getLogger(Philosopher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
