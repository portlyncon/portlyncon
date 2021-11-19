package curs_java.ecercicis.exception2;

import java.util.ArrayList;

public class Pizzeria {

    ArrayList<Pizza> Lista_pizzas = new ArrayList<>();

    public Pizzeria(ArrayList<Pizza> lista) {

        this.Lista_pizzas = lista;

    }

    public void comanda(PizzaComanda pi_co) {

        if (!Lista_pizzas.contains(pi_co)) {
            System.out.println("Comanda Guay");
            if (Buscar_queso_max(pi_co)) {
                throw new Pizza_error(Pizza_error.tooMuchCheeseError);
            }
        } else
            throw new Pizza_error(Pizza_error.pizza_error);

    }

    public boolean Buscar_queso_max(PizzaComanda pi) {
        boolean superior = false;
        for (Pizza pizza : Lista_pizzas) {
            if (pizza.getNombre().equals(pi.getNombre())) {
                if (pizza.getMax_Queso() < pi.getMax_Queso()) {
                    superior = true;
                }
            } else {
                System.out.println("Este perfil es privado");
            }
        }
        return superior;
    }

}
