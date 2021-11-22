package curs_java.ecercicis.exception2;

import java.util.ArrayList;
import java.util.Scanner;

public class prova {

    public static void main(String[] args) {

        ArrayList<Pizza> lista = new ArrayList<>();
        Pizza pizza_nova = new Pizza("prova", 3, 3.5);
        Pizzeria pi = new Pizzeria(lista);
        pi.Lista_pizzas.add(pizza_nova);
        String nombre_pizza = "";
        int cantidad_pizzas = 0;
        int cantidad_queso = 0;
        double precio = 0.0;
        PizzaComanda pi_co = new PizzaComanda(nombre_pizza, cantidad_queso, precio, cantidad_pizzas);
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

                        System.out.println("nombre: " + pizza.getNombre() + "precio: " + pizza.getPrecio());
                    }
                } catch (Pizza_error e) {
                    System.out.println(e.getMessage());
                }

                break;
            case 2:
                sn.nextLine();
                System.out.println("Que pizza quieres comprar..");
                nombre_pizza = sn.nextLine();
                sn.nextLine();
                System.out.println("Que cantidad de queso quieres...");
                cantidad_queso = sn.nextInt();
                sn.nextLine();
                System.out.println("Que cantidad de pizzas quieres...");
                cantidad_pizzas = sn.nextInt();
                sn.nextLine();
                try {
                    pi.comanda(pi_co);

                } catch (Pizza_error e) {
                    // TODO: handle exception
                }

                total_comanda = total_comanda + pi_co.getPrecio();
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
