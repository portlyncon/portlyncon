
package curs_java.ecercicis.barajaespanyola;

public class Carta {

    int numero;
    String palo;

    public Carta() {
    }

    public Carta(int n, String p) {
        numero = n;
        palo = p;
    }

    // s'ha de impementar el metode iquals per saber si ja existeix aquesta carta
    public boolean equals(Object o) {

        boolean isEqual = false;
        if (o instanceof Carta) {
            Carta it = (Carta) o;
            isEqual = (this.palo) == (((Carta) o).getName()) && (this.numero) == (((Carta) o).getNumero());
        }
        return isEqual;
    }

    public String getName() {
        return this.palo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void mostrar() {

        System.out.println("Numero: " + numero);
        System.out.println("Palo: " + palo);

    }
}