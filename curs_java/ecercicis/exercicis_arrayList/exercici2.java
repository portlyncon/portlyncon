package curs_java.ecercicis.exercicis_arrayList;

import java.util.ArrayList;
import java.util.Random;

public class exercici2 {

    public static void main(String[] args) {
        ArrayList<Integer> numers = new ArrayList<>(20);
        ArrayList<Integer> primos = new ArrayList<>(20);
        Random rand = new Random();
        for (int i = 1; i <= 10; i++) {

            Integer num = rand.nextInt(99 + 1);
            if (esprimo(num)) {

                primos.add(num);

            }
        }

        System.out.println("Array entrada" + numers.toString());
        System.out.println("Array de primos" + primos.toString());
    }

    public static boolean esprimo(Integer num) {
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != num)) {
            if (num % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
}
