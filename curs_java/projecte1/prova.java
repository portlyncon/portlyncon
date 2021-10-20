package curs_java.projecte1;

import java.util.Arrays;
import java.util.stream.Stream;

public class prova {

    public static void main(String arg[]) {

        System.out.println("provaaaaaaaaaaaaaaaaa");

        int[] numeros1 = { 3, 7, 8, 9 };
        int[] numeros2 = numeros1;
        // LA MISMA POSICION DE MEMORIA
        numeros2[2] = 90;
        System.out.println(numeros1);
        System.out.println(numeros2);

        Stream.of(numeros1).forEach((item) -> System.out.println(item));
        // Listarelementos
        Arrays.stream(numeros1).forEach((item) -> System.out.println(item));
    }

}