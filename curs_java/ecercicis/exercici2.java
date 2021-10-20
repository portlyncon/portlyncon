package curs_java.ecercicis;

import java.util.Scanner;

public class exercici2 {
    public static void main(String arg[]) {

        System.out.println("INTRODUCE UN CARACTER: ");

        Scanner sc = new Scanner(System.in);

        String texto = sc.next();

        if (!texto.isEmpty()) {
            char c = texto.charAt(0);

            if (c >= 65 && c <= 90) {
                System.out.println("Es mayuscula");
            } else {
                System.out.println("No Es mayuscula");
            }

        }

    }

}
