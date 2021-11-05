package curs_java.ecercicis.baraja_española;

public class estetica {

    // variables
    String titulo = "Baraja Española";

    public void limpiarln(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println("");
    }

    public void limpiarlnSM(String simbolo, int num) {
        for (int i = 0; i < num; i++) {
            System.out.print(simbolo);
        }
        System.out.println("");
    }

    public void limpiar(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
    }

    public void titulo() {
        limpiarln(25);

        limpiar(5);
        System.out.print(titulo);
        limpiarln(5);

        limpiarln(25);
    }

    public void credito() {
        limpiarln(25);

        limpiar(5);

        limpiarln(5);

        limpiarln(25);
    }
}