/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicis;

/**
 *
 * @author srpopo
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author Toni
 */
public class ConsumidorProducto {

    public static final int P_DELAY = 3000;
    public static final int C_DELAY = 1000;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10);
        
        Buffer<Integer> buffer = new Buffer<Integer>(10);
        Productor p = new Productor(buffer);
        Consumidor c = new Consumidor(buffer);
        
        es.submit(p);
        es.submit(p);
        //es.submit(p);
        //es.submit(p);
//        es.submit(p);
        
        es.submit(c);
        es.submit(c);
        //es.submit(c);
        //es.submit(c);
        //es.submit(c);

        try {
            es.awaitTermination(10, TimeUnit.SECONDS);
            es.shutdownNow();
            
        } catch (InterruptedException ex) {
            //Logger.getLogger(ConsumidorProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    public static void nap(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

}

class Buffer<E> {

    private final E[] data;
    private int nDatos;

    public Buffer(int size) {
        data = (E[]) new Object[size];
        nDatos = 0;
    }

    public synchronized void put(E x) {
        System.out.println(Thread.currentThread().getName()+" -> put()!!");
        data[nDatos++] = x;
        
        System.out.println(Thread.currentThread().getName()+" -> notifyAll()!!");
        notifyAll();
    }

    public synchronized E take() {
        System.out.println(Thread.currentThread().getName()+" -> take()!!");
        while (nDatos <= 0) {
            waiting();
        }

        E x = data[0];
        nDatos--;
        System.arraycopy(data, 1, data, 0, nDatos);
        data[nDatos] = null;
        
        return x;
    }

    private void waiting() {
        try {
            System.out.println(Thread.currentThread().getName()+" -> waiting() start!!");
            
            wait();
            
            System.out.println(Thread.currentThread().getName()+" -> waiting() exit!!");
        } catch (InterruptedException ignored) {
        }
    }

}

class Productor extends Thread {

    private final Buffer<Integer> buffer;
    private int n = 0;

    public Productor(Buffer<Integer> buffer) {
        this.buffer = buffer;        
    }

    @Override
    public void run() {
        while (true) {
            synchronized(this) {
                n++;
                System.out.println(Thread.currentThread().getName()+" -> P: " + n);
                buffer.put(n);
            }
            ConsumidorProducto.nap(ConsumidorProducto.P_DELAY);
        }
    }
}

class Consumidor extends Thread {

    private final Buffer<Integer> buffer;
    private int esperado = 0;

    public Consumidor(Buffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            esperado++;
            
            ConsumidorProducto.nap(ConsumidorProducto.C_DELAY);
            int n = buffer.take();
                
            System.out.println(Thread.currentThread().getName()+" -> C: " + n);
//            if (n != esperado) {
//                System.out.println("C: ERROR: esperado " + esperado);
//            }
            
        }
    }
}

