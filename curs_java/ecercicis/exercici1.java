package curs_java.ecercicis;

import java.util.Scanner;

public class exercici1 {
    public static void main(String arg[]) {

        System.out.println("INTRODUCE UN NUMERO: ");

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        boolean esPAr = (num & 1) == 0;

        if (esPAr) {
            System.out.println("es par");
        } else {
            System.out.println("NO es par");
        }
    }
}
