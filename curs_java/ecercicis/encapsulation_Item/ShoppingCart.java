package curs_java.ecercicis.encapsulation_Item;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

    static ArrayList<Item> arr = new ArrayList<Item>();

    public void addItem(Item it) {

        if (!arr.contains(it)) {
            arr.add(it);
            System.err.println("afeguit item");
        } else
            System.err.println("ja existeix aquest item");
    }

    public void delItem(String it) {

        boolean borrado = false;
        Item borrado_item = new Item();
        for (Item items : arr) {
            if (it.equals(items.getName())) {
                borrado = true;
                borrado_item = items;
            }
        }
        if (borrado) {
            arr.remove(borrado_item);
        } else
            System.err.println("no existeix aquest item");
    }

    /*
     * if (arr.contains(it)) {
     * 
     * arr.remove(it);
     * 
     * } else System.err.println("no existeix aquest item");
     */

    public Integer suma_total() {
        Integer precioTotal = 0;
        for (Item it : arr) {
            precioTotal += it.getPrice();
        }
        return precioTotal;
    }

    public ArrayList<String> Listar_Items() {
        ArrayList<String> lista = new ArrayList<String>();

        for (Item items : arr) {
            lista.add(items.getName());

        }

        return lista;

    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        ShoppingCart carrito = new ShoppingCart();

        int opcion; // Guardaremos la opcion del usuario
        do {
            System.out.println("1. Listar item en carrito");
            System.out.println("2. Añadir item al carrito");
            System.out.println("3. Eliminar item del carrito");
            System.out.println("4. Vaciar carrito");
            System.out.println("5. Mostrar importe total carrito");
            System.out.println("6. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
                switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado la opción 1");

                    for (int i = 0; i < carrito.Listar_Items().size(); i++) {

                        System.out.println(carrito.Listar_Items().get(i));
                    }

                    break;
                case 2:
                    sn.nextLine(); // limpiar el buffer
                    // System.out.println("Has seleccionado la opción 2");
                    System.out.println("Escribe nombre:");
                    String name = sn.nextLine();
                    System.out.println("Escribe descripcion:");
                    String des = sn.nextLine();
                    des = "prova";
                    System.out.println("Escribe precio:");
                    Integer pre = sn.nextInt();
                    if (pre > 0) {
                        Item nuevo = new Item(name, des, pre);
                        carrito.addItem(nuevo);
                    }
                    break;
                case 3:
                    System.out.println("Has seleccionado la opción 3");
                    System.out.println("Escribe el nombre del item a borrar");
                    sn.nextLine(); // limpiar el buffer

                    String item_del = sn.nextLine();
                    carrito.delItem(item_del);
                    break;
                case 4:
                    System.out.println("Has seleccionado la opción 4");
                    arr.clear();
                    break;
                case 5:
                    System.out.println("Has seleccionado la opción 5");
                    System.out.println("El importe total de l carrito es: " + carrito.suma_total());
                    break;
                case 6:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 6");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        } while (!salir);
    }

}
