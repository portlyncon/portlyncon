/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercici;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author srpopo
 */
public class SumAction extends RecursiveAction {

    private static final int SEQUENTIAL_THRESHOLD = 5;

    private List<Long> data;

    public SumAction(List<Long> data) {

        this.data = data;

    }

    @Override

    protected void compute() {

        if (data.size() <= SEQUENTIAL_THRESHOLD) { // base case

            long sum = computeSumDirectly();

            System.out.format("Sum of %s: %d\n", data.toString(), sum);

        } else { // recursive case

            // Calcuate new range
            int mid = data.size() / 2;

            SumAction firstSubtask
                    = new SumAction(data.subList(0, mid));

            SumAction secondSubtask
                    = new SumAction(data.subList(mid, data.size()));

            firstSubtask.fork(); // queue the first task

            secondSubtask.compute(); // compute the second task

            firstSubtask.join(); // wait for the first task result

            // Or simply call
            //invokeAll(firstSubtask, secondSubtask);
        }

    }
    
    private static void testParallelStream(List<Long> data) {

        final long start = System.currentTimeMillis();

        data.parallelStream().reduce(0L, Long::sum);
       
//        if (data.size() >= 2) { 
//        data.remove(1);
//        testParallelStream(data);
//        System.out.println(System.currentTimeMillis());
//        
//        }
//        
        

        System.out.println("Executed with a sequential stream in (ms): " + (System.currentTimeMillis() - start));

    }

    private long computeSumDirectly() {

        long sum = 0;

        for (Long l : data) {

            sum += l;

        }

        return sum;

    }

    public static void main(String[] args) {

        Random random = new Random();

        List<Long> data = random
                .longs(10, 1, 5)
                .boxed()
                .collect(toList());
        
        
        final long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();

        SumAction task = new SumAction(data);

        pool.invoke(task);
        System.out.println("Executed with ForkJoin in (ms): " + (System.currentTimeMillis() - start));
        
        
        testParallelStream(data);

    }

}


