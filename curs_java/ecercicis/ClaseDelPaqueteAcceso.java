package curs_java.ecercicis;

public class ClaseDelPaqueteAcceso {
    private int privado = 1;
    int paquete = 2;
    protected int protegido = 3;
    public int publico = 4;

    private void metodoPrivado() {
        System.out.println("Soy un método privado de la clase ClaseDelPaqueteAcceso.");
    }

    void metodoDePaquete() {
        System.out.println("Soy un método de paquete de la clase ClaseDelPaqueteAcceso.");
    }

    protected void metodoProtegido() {
        System.out.println("Soy un método protegido de la clase ClaseDelPaqueteAcceso.");
    }

    public void metodoPublico() {
        System.out.println("Soy un método público de la clase ClaseDelPaqueteAcceso.");
    }

    public static void main(String[] args) {
        ClaseDelPaqueteAcceso a = new ClaseDelPaqueteAcceso();
        System.out.println("Soy un atributo privado de la clase ClaseDelPaqueteAcceso: " +
                a.privado);
        System.out.println("Soy un atributo de paquete de la clase ClaseDelPaqueteAcceso: " +
                a.paquete);
        System.out.println("Soy un atributo protegido de la clase ClaseDelPaqueteAcceso: " +
                a.protegido);
        System.out.println("Soy un atributo público de la clase ClaseDelPaqueteAcceso: " +
                a.publico);

        System.out.println("");
        a.metodoPrivado();
        a.metodoDePaquete();
        a.metodoProtegido();
        a.metodoPublico();
    }
}
