package curs_java.ecercicis.baraja_española;

import java.util.Stack;
import java.util.Scanner;

public class Baraja {

    // Variables
    static Stack<Carta> baraja = new Stack<Carta>();
    // static estetica ds = new estetica();

    public static void main(String[] args) {
        // ds.titulo();
        menu();
        System.out.println("Programa finalizado correctamente");
        // ds.credito();
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
                getCarta();
                break;
            case 3:
                if (confirma("salir")) {
                    salir = true;
                }
                break;
            default:
                System.out.println("La opcion escogida no es valida");
            }
            // ds.limpiarln(25);
        }
        entrada.close();
    }

    public static void baraja() {
        // Scanner entrada = new Scanner(System.in);

        // System.out.println("De cuantas cartas quieres barajar");
        int numCartas = 40;// entrada.nextInt();

        if (baraja.empty()) {
            // Comienza a añadir cartas
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
        // Obtenemos numeros aleatorios
        int numC = random(1, 10);
        int paloI = random(1, 4);
        String paloC = null;

        // Convertimos palo en String
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

        // Generamos la nueva carta en la baraja
        baraja.push(new Carta(numC, paloC));
    }

    public static int random(int min, int max) {
        // Genera un numero aleatorio
        int num = (int) (Math.random() * max + min);
        return num;
    }

    public static void getCarta() {
        // Comprobamos que no este vacia la baraja
        // ds.limpiarln(25);

        if (baraja.empty()) {
            System.out.println("La baraja esta vacia, baraja de nuevo primero");
        } else {
            baraja.pop().mostrar();
        }

        System.out.println("Te quedan " + baraja.size() + " cartas en la baraja");
    }

    public static boolean confirma(String mensaje) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Estas seguro de que quieres " + mensaje);
        System.out.println("1. Si, quiero " + mensaje);
        System.out.println("2. No, no quiero " + mensaje);
        int seguro = entrada.nextInt();
        if (seguro == 1) {
            entrada.close();
            return true;
        } else {
            System.out.println("Cancelado");
        }
        entrada.close();
        return false;
    }

}