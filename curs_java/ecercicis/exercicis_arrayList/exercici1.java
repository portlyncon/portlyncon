package curs_java.ecercicis.exercicis_arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class exercici1 {

    ArrayList<Integer> numers = new ArrayList<>();

    public static void main(String[] args) {
        ArrayList<Integer> numers = new ArrayList<>(10);
        Random rand = new Random();
        for (int i = 1; i <= 10; i++) {

            Integer num = rand.nextInt(1000 + 1);
            numers.add(num);
        }
        System.out.println("El mes gran es" + valor_mayor(numers));
        System.out.println("El mes gran es" + valor_menor(numers));
    }

    public static Integer valor_mayor(ArrayList<Integer> vector) {

        Integer max = 0;
        for (int x = 0; x < vector.size(); x++) {

            if (vector.get(x) > max) {

                max = vector.get(x);

            }

        }
        return (max);

    }

    // per saber el max o el minim de collections Integer max =
    // Collections.max(vector);
    public static Integer valor_menor(ArrayList<Integer> vector) {

        Integer min = Collections.min(vector);

        return (min);

    }
}
/*
 * for (int i = 0; i < 100; i++){ if (maximo < lista[i]) maximo = lista[i]; if
 * (minimo > lista[i]) minimo = lista[i]; }
 * 
 * // Al finalizar el bucle, las variables contienen los valores máximos y
 * mínimos. System.out.println("La máximo de la lista es " + maximo);
 * System.out.println("La mínimo de la lista es " + minimo);
 */