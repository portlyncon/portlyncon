/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercici;
import exercici.SequentialCalculator;

public class DiningPhilosophers {

    public static final int N = 5;
    public static final int M = 4;
    
    public static void main(String[] args) {
        
        Table table = new Table();
        //double[] numbers = new double[M];
        //SequentialCalculator sequentialCalculator;
//        exempleForkJoin pp = new exercici.exempleForkJoin();
//        Double ii = pp.compute();
//        
//        System.err.println(ii);
//                System.err.println("rrrrrrrrrrrrrrrrrrrrrrrr");
           
        ahora();
                
//        long inici, fi;
//        double[] numbers = new double[M];
//        SequentialCalculator sequentialCalculator = (double[] numbers1, int start, int end) -> {
//            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        };
//        
//        //exempleForkJoin nou = new exempleForkJoin(numbers,sequentialCalculatorq);
//     
        exercici.Fork[] forks = new Fork[N];
        exercici.Philosopher[] philos = new Philosopher[N];
//        inici = System.currentTimeMillis();
//        System.err.println(inici);
//        //nou.compute();
//        
//        inici = System.currentTimeMillis();
//        System.err.println(inici);
//        exempleForkJoin leftTask = new exempleForkJoin(numbers,1, 1 + 10000000/2,sequentialCalculator);
//        leftTask.fork();
//        exempleForkJoin rightTask = new exempleForkJoin(numbers,1,100000000,sequentialCalculator);
//        Double rightResult = rightTask.compute();
//        Double leftResult = leftTask.join();
//        fi = System.currentTimeMillis();
//        System.out.println(fi-inici);
        //System.out.println(rightResult.toString(),leftResult.toString());
        //return leftResult + rightResult;
  
        
        //creamos los tenedores
        for (int i = 0; i < N; i++) {
            forks[i] = new Fork();
        }
        

        //creamos los filosofos
        for (int i = 0; i < N; i++) {
            philos[i] = new Philosopher(table, forks[i], forks[ (i+1)%N ]);
            philos[i].setName("Philosopher "+ (i+1));
            philos[i].start();
        }
        
        
    }
    
    private static synchronized void ahora(){
        exempleForkJoin pp = new exercici.exempleForkJoin();
        Double ii = pp.compute();
        
        System.err.println(ii);
                System.err.println("rrrrrrrrrrrrrrrrrrrrrrrr");
    }
}
