package curs_java.ecercicis.exception2;

public class Pizza {
    String nombre;
    int max_queso;
    double precio;

    public Pizza() {

    }

    public Pizza(String nom, int max_q, double pre) {

        this.nombre = nom;
        this.max_queso = max_q;
        this.precio = pre;

    }

    public boolean equals(Object o) {

        boolean isEqual = false;
        if (o instanceof Pizza) {
            Pizza it = (Pizza) o;
            isEqual = (this.nombre) == (((Pizza) o).getNombre());
        }
        return isEqual;
    }

    public String getNombre() {

        return nombre;
    }

    public int getMax_Queso() {
        return max_queso;

    }

}
