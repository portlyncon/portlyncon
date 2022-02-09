package curs_java.filosofos;

public class Philosopher extends Thread {

    int derecha = 0;
    int izquierda = 1;
    private final Fork tenedor;

    public Philosopher(Fork tenedor) {
        this.tenedor = tenedor;
    }

    @Override
    public void run() {
        while (true) {

            String estado = EstadoFilosofo.THINKING.toString();
            // ConsumidorProducto.nap(ConsumidorProducto.C_DELAY);

        }
    }

}
