package curs_java.ecercicis.exception2;

public class PizzaComanda extends Pizza {

    int Cantidad_pizzas;

    public PizzaComanda(String nom, int max_q, double pre, int cantidad_pizzas) {
        this.Cantidad_pizzas = cantidad_pizzas;
        this.nombre = nom;
        this.max_queso = max_q;
        this.precio = pre;

        // TODO Auto-generated constructor stub
    }

    /*
     * public int getMax_Queso() { return this.max_queso; }
     */
}
