/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercicis;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author srpopo
 */
public class exercici1 extends Thread{
    
    @Override
public void run() {
for(int i = 0; i < 10; i++) {
System.out.println("i:" + i);
}
}

public static void main(String[] args) throws InterruptedException {

Thread t = new exercici1();
t.start();

ExecutorService executorService = Executors.newFixedThreadPool(10);
Future future = executorService.submit(()-> System.out.println("Asynchronous task")
);
        try {
            future.get();
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
executorService.shutdown();

ExecutorService executorService2 = Executors.newFixedThreadPool(10);
Future future2 = executorService2.submit(new Callable(){
public Object call() throws Exception {
System.out.println("Asynchronous Callable");
return "DASDASDASDASDASDASDASDASDASDASDASDASDDASDASCallable Result";
}
});
        try {
            System.out.println("future.get() = " + future2.get());
        } catch (ExecutionException ex) {
            ex.printStackTrace();
        }
executorService2.shutdown();

}
}

    

