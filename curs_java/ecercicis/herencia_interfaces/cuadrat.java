package curs_java.ecercicis.herencia_interfaces;

public class cuadrat implements interface_poligon {

    int[] vertx_a = { 0, 0 };;
    int[] vertx_b = { 0, 0 };;
    int[] vertx_c = { 0, 0 };;
    int[] vertx_d = { 0, 0 };;
    double perimetre;
    double area;
    double distancia;

    public cuadrat() {

    }

    public cuadrat(int[] a, int[] b, int[] c, int[] d) {
        vertx_a = a;
        vertx_b = b;
        vertx_c = c;
        vertx_d = d;
    }

    @Override
    public void met_Area() {

        // TODO Auto-generated method stub
        area = (calcular_distancia(vertx_a, vertx_b)) * (calcular_distancia(vertx_a, vertx_c));
    }

    @Override
    public void met_Perimetre() {
        // TODO Auto-generated method stub
        perimetre = (calcular_distancia(vertx_a, vertx_b) + calcular_distancia(vertx_a, vertx_c)
                + calcular_distancia(vertx_b, vertx_c) + calcular_distancia(vertx_b, vertx_c));
    }

    public double calcular_distancia(int[] p1, int[] p2) {

        distancia = Math.sqrt((p1[0] - p1[1]) * (p1[0] - p1[1]) + (p2[0] - p2[1]) * (p2[0] - p2[1]));

        return distancia;

    }

    public double getPerimetre() {
        met_Perimetre();
        return perimetre;
    }

    public double getArea() {
        met_Area();
        return area;
    }

}
