/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio2 {

    public static void main(String[] args) {
        long start, end;
        List<String> lst = Arrays.asList("hola", "adios", "perro", "gato", "pájaro", "caballo", "pepe", "manolo",
                "maria", "mónica");

        List<Long> times = new ArrayList<>();
        List<String> texts2search = Arrays.asList("hola", "caballo", "maria");

        for (String text2search : texts2search) {
            start = System.currentTimeMillis();
            invokeAny(lst, text2search);
            end = System.currentTimeMillis();
            System.out.println("invoke any -> " + (end - start) + "ms");
            times.add(end - start);
        }
        long media = times.stream().reduce(0L, (t, s) -> s + t) / times.size();
        System.out.println("invoke any media -> " + media + "ms");

        System.out.println("");

        times.clear();
        for (String text2search : texts2search) {
            start = System.currentTimeMillis();
            invokeAll(lst, text2search);
            end = System.currentTimeMillis();
            System.out.println("invoke all -> " + (end - start) + "ms");
            times.add(end - start);
        }
        media = times.stream().reduce(0L, (t, s) -> s + t) / times.size();
        System.out.println("invoke all media -> " + media + "ms");

        System.out.println("");

        times.clear();
        for (String text2search : texts2search) {
            start = System.currentTimeMillis();
            System.out.println("La posicion de " + text2search + " es " + lst.indexOf(text2search));
            end = System.currentTimeMillis();
            System.out.println("indexof -> " + (end - start) + "ms");
            times.add(end - start);
        }
        media = times.stream().reduce(0L, (t, s) -> s + t) / times.size();
        System.out.println("indexof media -> " + media + "ms");

        System.out.println("");

        times.clear();
        for (String text2search : texts2search) {
            start = System.currentTimeMillis();
            lst.stream().filter(t -> t.equals(text2search)).findAny();
            end = System.currentTimeMillis();
            System.out.println("stream() -> " + (end - start) + "ms");
            times.add(end - start);
        }
        media = times.stream().reduce(0L, (t, s) -> s + t) / times.size();
        System.out.println("stream() media -> " + media + "ms");

        System.out.println("");

        times.clear();
        for (String text2search : texts2search) {
            start = System.currentTimeMillis();
            lst.stream().parallel().filter(t -> t.equals(text2search)).findAny();
            end = System.currentTimeMillis();
            System.out.println("stream().parallel() -> " + (end - start) + "ms");
            times.add(end - start);
        }
        media = times.stream().reduce(0L, (t, s) -> s + t) / times.size();
        System.out.println("stream().parallel() media -> " + media + "ms");

    }

    public static void invokeAny(List<String> lst, String text2search) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> lstCallables = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            lstCallables.add(new SearchThread(lst, i, text2search));
        }

        try {

            Integer pos = executorService.invokeAny(lstCallables);
            System.out.println("La posicion de " + text2search + " es " + pos);

        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }

        executorService.shutdown();
    }

    public static void invokeAll(List<String> lst, String text2search) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Callable<Integer>> lstCallables = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            lstCallables.add(new SearchThread(lst, i, text2search));
        }

        try {

            List<Future<Integer>> lstPos = executorService.invokeAll(lstCallables);
            for (Future<Integer> fut : lstPos) {
                if (fut.get() != null) {
                    System.out.println("La posicion de " + text2search + " es " + fut.get());
                }
            }

        } catch (InterruptedException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }

        executorService.shutdown();
    }
}

class SearchThread implements Callable<Integer> {
    List<String> lst;
    Integer pos;
    String text2search;

    public SearchThread(List<String> lst, Integer pos, String text2search) {
        this.lst = lst;
        this.pos = pos;
        this.text2search = text2search;
    }

    public Integer call() throws InterruptedException {
        if (pos != null && pos >= 0 && pos < this.lst.size()) {
            if (text2search.equals(this.lst.get(this.pos))) {
                return this.pos;
            }
        }
        // Thread.sleep(50);
        return null;
    }
}
