
package curs_java.ecercicis.baraja_española;

public class Carta {

    // Variables
    int numero;
    String palo;
    estetica ds = new estetica();

    public Carta(int n, String p) {
        numero = n;
        palo = p;
    }

    public void mostrar() {
        ds.limpiarlnSM("#", 25);
        System.out.println("Numero: " + numero);
        System.out.println("Palo: " + palo);
        ds.limpiarlnSM("#", 25);
    }
}