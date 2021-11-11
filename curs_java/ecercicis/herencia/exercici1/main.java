package curs_java.ecercicis.herencia.exercici1;

import java.util.ArrayList;

public class main {

    ArrayList<interface_poligon> arr = new ArrayList<>();

    public static void main(int[] args) {
        int[] a = { 1, 2 };
        int[] b = { 3, 6 };
        int[] c = { 5, 4 };
        int[] d = { 3, 5 };

        triangle tri = new triangle(a, b, c);
        cuadrat cua = new cuadrat(a, b, c, d);

        System.out.println("area :" + cua.getArea());
        System.out.println("area :" + tri.getArea());

    }

}
