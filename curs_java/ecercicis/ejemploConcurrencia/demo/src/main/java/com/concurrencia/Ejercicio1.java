/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Toni
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        // ejecución directa de un Thread
        new SimpleThread().start();

        // ejecución directa de un Runable
        Thread t = new Thread(new SimpleThreadRunnable());
        t.start();
        try {
            t.join(); // con el join quedamos a la espera de que termine el thread
        } catch (InterruptedException ex) {
            // Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Terminada la ejecución del Thread SimpleThreadRunnable()");

        // Creamos un ejecutador con capacidad para 10 hilos simultaneos
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Lanzamos a ejecución nuestro hilo.
        // Con submit podemos obtener el elemento Future para poder saber cuando acaba
        SimpleThread st = new SimpleThread();

        Future future = executorService.submit(st);
        executorService.submit(st);
        executorService.submit(st);
        executorService.submit(st);

        executorService.shutdown();

        try {
            future.get();
        } catch (InterruptedException ex) {
            // Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            // Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Terminada la ejecución de SimpleThread en el ExecutorService");

    }
}

class SimpleThread extends Thread {
    public void run() {
        System.out.println("Hello");
        try {
            this.sleep(2000);
        } catch (InterruptedException ex) {
            // Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Goodbye");
    }
}

// Opcion de implementación con la interfaz Runnable. Ojo, aquí no tenemos el
// this.sleep() pero el método es static
class SimpleThreadRunnable implements Runnable {
    public void run() {
        System.out.println("Hello");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            // Logger.getLogger(SimpleThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Goodbye");
    }
}
