/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curs_java.ecercicis.ejemploConcurrencia;

import java.util.concurrent.Executors;

/**
 *
 * @author Toni
 */
public class ExampleClass {

    public static void main(String[] args) throws InterruptedException {
        AnimalRunnable anr = new AnimalRunnable();

        Thread cat = new Thread(anr);
        cat.setName("Cat");
        Thread dog = new Thread(anr);
        dog.setName("Dog");
        Thread cow = new Thread(anr);
        cow.setName("Cow");

        System.out.println("Thread State of Cat before calling start: " + cat.getState());

        cat.start();
        dog.start();
        cow.start();

        System.out.println("Thread State of Cat in Main method before Sleep: "
                + cat.getState());
        System.out.println("Thread State of Dog in Main method before Sleep: "
                + dog.getState());
        System.out.println("Thread State of Cow in Main method before Sleep: "
                + cow.getState());

        Thread.sleep(10000);

        System.out.println("Thread State of Cat in Main method after sleep: " +
                cat.getState());
        System.out.println("Thread State of Dog in Main method after sleep: " +
                dog.getState());
        System.out.println("Thread State of Cow in Main method after sleep: " +
                cow.getState());
    }
}

class AnimalRunnable implements Runnable {

    @Override
    public void run() {
        for (int x = 1; x < 4; x++) {
            System.out.println("Run by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println(
                "Thread State of: " + Thread.currentThread().getName() + " - " + Thread.currentThread().getState());
        System.out.println("Exit of Thread: " + Thread.currentThread().getName());
    }
}
