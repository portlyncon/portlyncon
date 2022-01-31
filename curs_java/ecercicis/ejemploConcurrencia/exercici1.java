package curs_java.ecercicis.ejemploConcurrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class exercici1 implements Runnable {


    ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {

         @Override
        public void run() {
            // TODO Auto-generated method stub
            System.out.println("Hello");
            
        }
        
});

}
