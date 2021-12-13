package curs_java.ecercicis.exerciciEnum;

public class Hucha {

    double total;

    public Hucha() {

    }

    public void add(int n, MonedaBillete type) {

        total = total + type.calcularImporte(n);

    }

    public double importeTotal() {

        return total;
    }

    public void vaciar() {

        total = 0.0;
    }
}
