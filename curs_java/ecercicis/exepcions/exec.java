package curs_java.ecercicis.exepcions;

import java.util.Scanner;

public class exec {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        Adivina adi = new Adivina();
        System.out.println(adi.numero);
        String opcion; // Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Adivina el numero magico");
            System.out.println("2. Salir");
            int op = sn.nextInt();

            switch (op) {
            case 1:
                sn.nextLine();
                System.out.println("introduce un entero entre 1 y 500");
                opcion = sn.nextLine();
                // System.out.println(opcion);
                try {
                    System.out.println(adi.adivina(opcion));

                } catch (adivinaException e) {
                    this.getOut().println(e.getMessage());
                }

                break;
            case 2:
                salir = true;
                break;

            }
        }
    }
}
