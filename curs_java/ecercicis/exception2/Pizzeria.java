package curs_java.ecercicis.exception2;

import java.util.ArrayList;

public class Pizzeria {

    ArrayList<Pizza> Lista_pizzas = new ArrayList<>();
    double precio;

    public Pizzeria(ArrayList<Pizza> lista) {

        this.Lista_pizzas = lista;

    }

    public double comanda(PizzaComanda pi_co) {

        if (!Lista_pizzas.contains(pi_co)) {
            System.out.println("Comanda Guay");
            if (Buscar_queso_max(pi_co)) {
                throw new TooMuchCheeseError(TooMuchCheeseError.tooMuchCheeseError);
            }
        } else
            throw new Pizza_error(Pizza_error.pizza_error);
        return precio;
    }

    public boolean Buscar_queso_max(PizzaComanda pi) {
        boolean superior = false;
        for (Pizza pizza : Lista_pizzas) {
            if (pizza.getNombre().equals(pi.getNombre())) {
                if (pizza.getMax_Queso() < pi.getMax_Queso()) {
                    superior = true;
                }
                precio = pizza.getPrecio();
            } else {
                System.out.println("OK");
            }
        }
        return superior;
    }

    public double precio_pizza_comanda() {
        return precio;
    }

}
