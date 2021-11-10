package curs_java.ecercicis.herencia.exercici1;

public class triangle implements interface_poligon {

    int[] vertx_a = { 0, 0 };
    int[] vertx_b = { 0, 0 };;
    int[] vertx_c = { 0, 0 };;
    int perimetre;
    int area;
    int distancia;

    public triangle(int[] a, int[] b, int[] c) {
        vertx_a = a;
        vertx_b = b;
        vertx_c = c;
    }

    @Override
    public void met_Area() {
        // TODO Auto-generated method stub

    }

    @Override
    public void met_Perimetre() {
        // TODO Auto-generated method stub

    }

    public int calcular_distancia(int p1, int p2) {
        return distancia;

    }

    public int getPerimetre() {
        return perimetre;
    }

    public int getArea() {
        return area;
    }

}
