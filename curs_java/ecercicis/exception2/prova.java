package curs_java.ecercicis.exception2;

import java.util.ArrayList;
import java.util.Scanner;

public class prova {

    public static void main(String[] args) {

        ArrayList<Pizza> lista = new ArrayList<>();
        Pizza pizza_nova = new Pizza("prova", 3, 3.5);// pizza de prueba
        Pizzeria pi = new Pizzeria(lista);// Lista de prueba
        pi.Lista_pizzas.add(pizza_nova);
        String nombre_pizza = "";
        int cantidad_pizzas = 0;
        int cantidad_queso = 0;
        double precio = 0.0;
        PizzaComanda pi_co = new PizzaComanda();
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        double total_comanda = 0.0;

        while (!salir) {

            System.out.println("1. Consulta Lista de Pizzas");
            System.out.println("2. Hacer pedido Pizza");
            System.out.println("3. Finalizar Comanda");
            int op = sn.nextInt();
            switch (op) {
            case 1:
                sn.nextLine();
                try {

                    for (Pizza pizza : pi.Lista_pizzas) {

                        System.out.println("nombre: " + pizza.getNombre() + " precio: " + pizza.getPrecio());
                    }
                } catch (Pizza_error e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 2:
                sn.nextLine();
                System.out.println("Que pizza quieres comprar..");
                nombre_pizza = sn.nextLine();
                System.out.println(nombre_pizza);
                System.out.println("Que cantidad de queso quieres...");
                cantidad_queso = sn.nextInt();
                System.out.println(cantidad_queso);
                sn.nextLine();
                System.out.println("Que cantidad de pizzas quieres...");
                cantidad_pizzas = sn.nextInt();
                System.out.println(cantidad_pizzas);

                sn.nextLine();
                try {

                    pi_co = new PizzaComanda(nombre_pizza, cantidad_queso, precio, cantidad_pizzas);
                    precio = pi.comanda(pi_co);

                    System.out.println(precio);
                    total_comanda = total_comanda + (precio * cantidad_pizzas);
                } catch (Pizza_error e) {
                    System.out.println(e.getMessage());

                }

                break;
            case 3:

                System.out.println("Total Comanda: " + total_comanda);
                salir = true;
                break;
            }
        }
        sn.close();

    }

}
