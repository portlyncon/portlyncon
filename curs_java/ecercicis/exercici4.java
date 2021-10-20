package curs_java.ecercicis;

import java.util.Scanner;

public class exercici4 {

    public static void main(String arg[]) {

        System.out.println("Introduce 10 numeros: ");

        Scanner sc = null;
        int contadorPares = 0, sumaPares = 0, contadorImpares = 0, sumaImpares = 0;
        double mediaPares = 0, mediaImpares = 0;
        int[] valores = new int[10];
        System.out.println("Introduce un 10 valores enteros: ");
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el valor " + (i + 1) + ": ");
            sc = new Scanner(System.in);
            valores[i] = sc.nextInt();
            if ((valores[i] & 1) == 0) {
                contadorPares++;
                sumaPares += valores[i];
            } else {
                contadorImpares++;
                sumaImpares += valores[i];
            }
        }
        if (contadorPares != 0) {
            mediaPares = sumaPares / contadorPares;
        }
        System.out.println("La media de los pares es: " + mediaPares);
        if (contadorImpares != 0) {
            mediaImpares = sumaImpares / contadorImpares;
        }
        System.out.println("La media de los pares es: " + mediaImpares);

        System.out.println("La media de las medias es: " + (mediaPares + mediaImpares) / 2);
        sc.close();

    }

}
