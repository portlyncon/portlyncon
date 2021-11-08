package curs_java.ecercicis.barajaespanyola;

import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {

    static Stack<Carta> baraja = new Stack<Carta>();
    static ArrayList<Carta> arr = new ArrayList<Carta>();
    static ArrayList<Carta> mon = new ArrayList<Carta>();

    public static void main(String[] args) {

        menu();
        System.out.println("Programa finalizado correctamente");

    }

    public static void menu() {
        Scanner entrada = new Scanner(System.in);
        int index = 39;
        boolean salir = false;
        while (!salir) {

            System.out.println("1. Barajar las cartas");
            System.out.println("2. siguiente carta");
            System.out.println("3. cartas disponibles");
            System.out.println("4. pedir cartas");
            System.out.println("5. listar cartas del monton");
            System.out.println("6. mostrar baraja");
            System.out.println("7. Salir");
            int opcion = entrada.nextInt();

            switch (opcion) {
            case 1:
                baraja();

                reordenar();

                break;
            case 2:
                if (index >= 0) {
                    siguienteCarta(index);
                    index = index - 1;
                }
                break;
            case 3:

                cartesDisponibles(index);

                break;

            case 4:

                System.out.println("Quantes cartes vols?");
                entrada.nextLine(); // limpiar el buffer

                int numCartasPedidas = entrada.nextInt();
                if (numCartasPedidas < index) {
                    for (int i = 0; i < numCartasPedidas; i++) {
                        System.out.println("Carta: " + arr.get(index).palo + " " + arr.get(index).numero);
                        mon.add(arr.get(index));
                        index = index - 1;
                    }
                }
                break;

            case 5:

                if (mon.isEmpty()) {
                    System.out.println("no ha salido ninguna carta");
                } else {
                    listarCartasMonton();
                }
                break;

            case 6:

                mostrarBaraja(index);

                break;

            case 7:

                salir = true;

                break;
            default:
                System.out.println("La opcion escogida no es valida");
            }

        }
        entrada.close();
    }

    private static void mostrarBaraja(int index) {
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i).palo + arr.get(i).numero);
        }

    }

    private static void listarCartasMonton() {
        for (int i = 0; i < mon.size(); i++) {
            System.out.println(mon.get(i).palo + mon.get(i).numero);
        }

    }

    private static void cartesDisponibles(int dis) {
        dis = dis + 1;
        System.out.println("Cartas disponibles: " + dis);

    }

    private static void reordenar() {
        Random rndm = new Random();
        Collections.shuffle(arr, rndm);

    }

    public static void baraja() {

        int numCartas = 13;

        // generem les 40 cartes

        for (int i = 1; i < numCartas; i++) {

            if (i != 8 && i != 9) {
                nuevaCarta(1, i);
            }
        }
        for (int j = 1; j < numCartas; j++) {

            if (j != 8 && j != 9) {
                nuevaCarta(2, j);
            }
        }
        for (int k = 1; k < numCartas; k++) {

            if (k != 8 && k != 9) {
                nuevaCarta(3, k);
            }
        }
        for (int l = 1; l < numCartas; l++) {
            if (l != 8 && l != 9) {
                nuevaCarta(4, l);
            }
        }
        /*
         * else { baraja.clear();
         * 
         * }
         */
        // System.out.println("Se han barajeado " + baraja.size() + " cartas");

    }

    public static void nuevaCarta(int palo, int num) {

        Boolean esta = true;

        while (esta) {

            String paloC = "";

            switch (palo) {
            case 1:
                paloC = "Oros";
                break;
            case 2:
                paloC = "Copas";
                break;
            case 3:
                paloC = "Espadas";
                break;
            case 4:
                paloC = "Bastos";
                break;
            }

            Carta nova = new Carta(num, paloC);

            if (!arr.contains(nova)) {
                arr.add(nova);
                System.out.println("oooooooooooooooooooooooooooo");
                esta = false;
            }

        }

    }

    public static void siguienteCarta(int index) {

        if (arr.isEmpty()) {

            System.out.println("La baraja esta vacia, baraja de nuevo primero");

        } else {

            System.out.println("Carta: " + arr.get(index).palo + " " + arr.get(index).numero);
            mon.add(arr.get(index));
        }

    }

}