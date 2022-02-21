/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author srpopo
 */

    
public class exempleForkJoin extends RecursiveTask<Double> {

   public static final long THRESHOLD = 1_000_000;

   //final SequentialCalculator sequentialCalculator;
   //private final double[] numbers;
   //private final int start;
   //private final int end;

//  public exempleForkJoin(double[] numbers, SequentialCalculator sequentialCalculator) {
//     this(numbers, 0, numbers.length, sequentialCalculator);
//   }

    exempleForkJoin() {
    //this.numbers = numbers;
     //this.start = start;
     //this.end = end;
     //this.sequentialCalculator = sequentialCalculator;
    }

   @Override
   protected synchronized Double compute() {
     
//     if (length <= THRESHOLD) {
//         return sequentialCalculator.computeSequentially(numbers, start, end);
//     }
     //System.err.println("dsdfasfadsfadfasdfsdfsdfs"); 
     //exempleForkJoin leftTask = new exempleForkJoin(end/2);
     //leftTask.fork();
     exempleForkJoin rightTask = new exempleForkJoin();
       ForkJoinTask<Double> rightResult = rightTask.fork();
     //Double leftResult = leftTask.compute();
     Double dObj3 = new Double("25.34");
    System.out.println(rightResult.toString());
     System.out.println("lllllllllll");
       try {
           Thread.sleep(5000);
       } catch (InterruptedException ex) {
           ex.printStackTrace();
       }
     return dObj3;
     

  }
   
    
}
