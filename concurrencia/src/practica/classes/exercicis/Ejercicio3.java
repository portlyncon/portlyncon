/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicis;

/**
 *
 * @author srpopo
 */
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class Ejercicio3 {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(10);

        System.out.println("Ejecuta dentro de 5s");

        ScheduledFuture sf = es.schedule(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
        }, 5, TimeUnit.SECONDS);

        Thread.sleep(10000);
        sf.cancel(true);
        System.out.println("Terminamos el de dentro de 5s");

        System.out.println("Iniciamos cada segundo");

        sf = es.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
        }, 0, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);
        sf.cancel(true);
        System.out.println("Terminamos el de cada segundo");

        System.out.println("Iniciamos cada segundo tardando 2");

        sf = es.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {

            }
        }, 0, 1, TimeUnit.SECONDS);

        Thread.sleep(10000);
        sf.cancel(true);
        System.out.println("Terminamos el de segundo tardando 2");

        System.out.println("Iniciamos cada 5 scheduleAtFixedRate tardando 2");

        sf = es.scheduleAtFixedRate(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {

            }
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(20000);
        sf.cancel(true);
        System.out.println("Terminamos el de scheduleAtFixedRate ");

        System.out.println("Iniciamos cada 5 scheduleWithFixedDelay tardando 2");

        sf = es.scheduleWithFixedDelay(() -> {
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {

            }
        }, 0, 5, TimeUnit.SECONDS);

        Thread.sleep(20000);
        sf.cancel(true);
        System.out.println("Terminamos el de scheduleWithFixedDelay ");

        es.shutdown();
    }
}