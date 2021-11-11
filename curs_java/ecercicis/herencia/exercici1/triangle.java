package curs_java.ecercicis.herencia.exercici1;

public class triangle implements interface_poligon {

    int[] vertx_a = { 0, 0 };
    int[] vertx_b = { 0, 0 };;
    int[] vertx_c = { 0, 0 };;
    double perimetre;
    double area;
    double distancia;

    public triangle() {

    }

    public triangle(int[] a, int[] b, int[] c) {
        vertx_a = a;
        vertx_b = b;
        vertx_c = c;
    }

    @Override
    public void met_Area() {
        // TODO Auto-generated method stub
        double altura = 0;
        altura = (calcular_distancia(vertx_a, vertx_b) + calcular_distancia(vertx_a, vertx_c)
                + calcular_distancia(vertx_b, vertx_c)) / 2;
        area = (Math.sqrt(altura * (altura - calcular_distancia(vertx_a, vertx_b))
                * (altura - calcular_distancia(vertx_a, vertx_c) * (altura - calcular_distancia(vertx_a, vertx_c)))));
        // area = ((calcular_distancia(vertx_a, vertx_b) * altura) / 2);
    }

    @Override
    public void met_Perimetre() {
        // TODO Auto-generated method stub
        perimetre = (calcular_distancia(vertx_a, vertx_b) + calcular_distancia(vertx_a, vertx_c)
                + calcular_distancia(vertx_b, vertx_c));
    }

    public double calcular_distancia(int[] p1, int[] p2) {

        distancia = Math.sqrt((p1[0] - p1[1]) * (p1[0] - p1[1]) + (p2[0] - p2[1]) * (p2[0] - p2[1]));

        return distancia;

    }

    @Override
    public double getPerimetre() {
        met_Perimetre();
        return perimetre;
        // TODO
    }

    @Override
    public double getArea() {
        met_Area();
        return area;
        // TODO
    }

}
