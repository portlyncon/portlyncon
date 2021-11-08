package curs_java.ecercicis.barajaespanyola;

import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Baraja {

    static Stack<Carta> baraja = new Stack<Carta>();
    static ArrayList<Carta> arr = new ArrayList<Carta>();

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
            System.out.println("3. Salir");
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

                salir = true;

                break;
            default:
                System.out.println("La opcion escogida no es valida");
            }

        }
        entrada.close();
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

        // pasem de int a String els pals de la baraja
        /*
         * switch (paloI) { case 1: paloC = "Oro"; break; case 2: paloC = "Copa"; break;
         * case 3: paloC = "Espada"; break; case 4: paloC = "Basto"; break; }
         */

        // ########################comprovar si la carta ja existeix
        // ###########################################
        /*
         * public void addItem(Item it) {
         * 
         * if (!arr.contains(it)) { arr.add(it); System.err.println("afeguit item"); }
         * else System.err.println("ja existeix aquest item"); }
         */

        // baraja.push(new Carta(numC, paloC));
    }

    /*
     * r/* eordenar el arraylist de arr con ArrayList reactivosR = new ArrayList();
     * reactivosR.add("r1"); reactivosR.add("r4"); reactivosR.add("r3");
     * reactivosR.add("r4"); reactivosR.add("r5"); reactivosR.add("r1");
     * reactivosR.add("r2"); reactivosR.add("r3"); reactivosR.add("r4");
     * reactivosR.add("r5"); Random rndm = new Random(); rndm.setSeed(1000);
     * Collections.shuffle(reactivosR, rndm); for(int i=1; i<10; i++) {
     * System.out.println("Reactivo ya randomizado: " + reactivosR.get(i)); }
     */

    /*
     * public static int random(int min, int max) {
     * 
     * int num = (int) (Math.random() * max + min); return num; }
     */
    public static void siguienteCarta(int index) {

        if (arr.isEmpty()) {

            System.out.println("La baraja esta vacia, baraja de nuevo primero");

        } else {

            System.out.println("Carta: " + arr.get(index).palo + " " + arr.get(index).numero);

        }
        /*
         * if (baraja.empty()) {
         * System.out.println("La baraja esta vacia, baraja de nuevo primero"); } else {
         * baraja.pop().mostrar();
         * 
         * }
         * 
         * System.out.println("Te quedan " + baraja.size() + " cartas en la baraja");
         */
    }

}