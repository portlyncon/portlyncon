package curs_java.ecercicis.baraja_española;

import java.util.Stack;
import java.util.Scanner;

public class Baraja {

    static Stack<Carta> baraja = new Stack<Carta>();

    public static void main(String[] args) {

        menu();
        System.out.println("Programa finalizado correctamente");

    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {

            System.out.println("1. Barajar las cartas");
            System.out.println("2. siguiente carta");
            System.out.println("3. Salir");
            int opcion = entrada.nextInt();

            switch (opcion) {
            case 1:
                baraja();
                break;
            case 2:
                siguienteCarta();
                break;
            case 3:

                salir = true;

                break;
            default:
                System.out.println("La opcion escogida no es valida");
            }

        }
        entrada.close();
    }

    public static void baraja() {

        int numCartas = 40;

        if (baraja.empty()) {// generem les 40 cartes

            for (int i = 0; i < numCartas; i++) {

                nuevaCarta();
            }
        } else {
            baraja.clear();
            for (int i = 0; i < numCartas; i++) {
                nuevaCarta();
            }
        }
        System.out.println("Se han barajeado " + baraja.size() + " cartas");
    }

    public static void nuevaCarta() {

        int numC = random(1, 10);
        int paloI = random(1, 4);
        String paloC = null;

        // pasem de int a String els pals de la baraja
        switch (paloI) {
        case 1:
            paloC = "Oro";
            break;
        case 2:
            paloC = "Copa";
            break;
        case 3:
            paloC = "Espada";
            break;
        case 4:
            paloC = "Basto";
            break;
        }

        // ########################comprovar si la carta ja existeix
        // ###########################################

        baraja.push(new Carta(numC, paloC));
    }

    public static int random(int min, int max) {

        int num = (int) (Math.random() * max + min);
        return num;
    }

    public static void siguienteCarta() {

        if (baraja.empty()) {
            System.out.println("La baraja esta vacia, baraja de nuevo primero");
        } else {
            baraja.pop().mostrar();

        }

        System.out.println("Te quedan " + baraja.size() + " cartas en la baraja");
    }

}