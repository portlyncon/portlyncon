package curs_java.ecercicis;

import java.util.Scanner;

public class exercici3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Escriba un límite: ");

            Integer limite = sc.nextInt();

            if (limite <= 1) {
                throw new Exception("Out of limit");
            }

            for (int i = 2; i < limite; i++) {
                Boolean esPrimo = true;
                for (int d = 2; d <= (int) Math.sqrt(i); d++) {
                    if (i % d == 0) {
                        esPrimo = false;
                        break;
                    }
                }
                if (esPrimo == true) {
                    System.out.println(i);
                }
            }
        } catch (Exception e) {
            System.out.println("Error en la entrada");
        }

        sc.close();

    }
}
