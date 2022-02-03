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
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Toni
 */
public class Ejercicio1_lista {

    public static void main(String[] args) throws ExecutionException {
        long start, end;
        List<String> lst = Arrays.asList("hola", "adios", "perro", "gato", "pájaro", "caballo", "pepe", "manolo",
                "maria", "mónica");

        // start = System.currentTimeMillis();
        // for (String item : lst) {
        // applyOperation(item);
        // }
        // end = System.currentTimeMillis();
        // System.out.println("for secuencial -> " + (end - start) + "ms");
        //
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //
        // start = System.currentTimeMillis();
        // Future<List<String>> f = executorService.submit(new ProcesaListaV1(lst));
        //
        // try {
        // f.get();
        // } catch (InterruptedException ex) {
        // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
        // ex);
        // } catch (ExecutionException ex) {
        // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
        // ex);
        // }
        //
        // end = System.currentTimeMillis();
        // System.out.println("ProcesaListaV1 todo -> " + (end - start) + "ms");
        //
        //
        // start = System.currentTimeMillis();
        // Future<List<String>> f1 = executorService.submit(new
        // ProcesaListaV1(lst.subList(0, lst.size() / 2)));
        // Future<List<String>> f2 = executorService.submit(new
        // ProcesaListaV1(lst.subList(lst.size() / 2, lst.size())));
        //
        // try {
        // f1.get();
        // f2.get();
        // } catch (InterruptedException ex) {
        // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
        // ex);
        // } catch (ExecutionException ex) {
        // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
        // ex);
        // }
        //
        // end = System.currentTimeMillis();
        // System.out.println("ProcesaListaV1 2 bloques -> " + (end - start) + "ms");

        start = System.currentTimeMillis();
        List<Future<String>> lstFutures = new ArrayList<>();
        for (int i = 0; i < lst.size(); i++) {
            lstFutures.add(executorService.submit(new ProcesaListaV2(lst, i)));
        }

        try {
            executorService.shutdown();
            executorService.awaitTermination(10_000, TimeUnit.MILLISECONDS);

            // List<String> lst2 = new ArrayList<>();
            // for(int i=0;i<lstFutures.size();i++) {
            // lst2.add(lstFutures.get(i).get());
            // }
            // lst = lst2;

            lst = lstFutures.stream().map(f -> {
                try {
                    return f.get();
                } catch (InterruptedException ex) {
                    // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
                    // ex);
                } catch (ExecutionException ex) {
                    // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
                    // ex);
                }

                return "";
            }).collect(Collectors.toList());

        } catch (InterruptedException ex) {
            // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
            // ex);
        }

        end = System.currentTimeMillis();
        System.out.println("ProcesaListaV2 por idx -> " + (end - start) + "ms");

        start = System.currentTimeMillis();

        lst.stream().map(item -> applyOperation(item)).collect(Collectors.toList());

        end = System.currentTimeMillis();
        System.out.println("Stream sequential -> " + (end - start) + "ms");

        start = System.currentTimeMillis();

        lst.stream().parallel().map(item -> applyOperation(item)).forEach(System.out::println);

        end = System.currentTimeMillis();
        System.out.println("Stream parallel -> " + (end - start) + "ms");
    }

    public static String applyOperation(String txt) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            // Logger.getLogger(Ejercicio1_lista.class.getName()).log(Level.SEVERE, null,
            // ex);
        }

        return txt.toUpperCase();
    }

}

// Callable que procesa toda la lista en segundo plano
class ProcesaListaV1 implements Callable<List<String>> {

    List<String> lst = new ArrayList<>();

    public ProcesaListaV1(List<String> lst) {
        this.lst = lst;
    }

    @Override
    public List<String> call() throws Exception {
        List<String> res = new ArrayList<>();
        for (String item : this.lst) {
            res.add(Ejercicio1_lista.applyOperation(item));
        }

        return res;
    }

}

// Callable que procesa un único elemento
class ProcesaListaV2 implements Callable<String> {

    List<String> lst = new ArrayList<>();
    int pos;

    public ProcesaListaV2(List<String> lst, int pos) {
        this.lst = lst;
        this.pos = pos;
    }

    @Override
    public String call() throws Exception {
        String res = Ejercicio1_lista.applyOperation(this.lst.get(this.pos));
        // this.lst.remove(this.pos);
        // this.lst.add(this.pos, res);

        return res;
    }

}
