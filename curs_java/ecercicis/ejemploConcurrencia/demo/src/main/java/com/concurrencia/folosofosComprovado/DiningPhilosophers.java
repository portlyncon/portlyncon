/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.folosofosComprovado;

public class DiningPhilosophers {

    public static final int N = 5;

    public static void main(String[] args) {
        Table table = new Table();
        Fork[] forks = new Fork[N];
        Philosopher[] philos = new Philosopher[N];

        // creamos los tenedores
        for (int i = 0; i < N; i++) {
            forks[i] = new Fork();
        }

        // creamos los filosofos
        for (int i = 0; i < N; i++) {
            philos[i] = new Philosopher(table, forks[i], forks[(i + 1) % N]);
            philos[i].setName("Philosopher " + (i + 1));
            philos[i].start();
        }

    }
}
