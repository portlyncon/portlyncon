package curs_java.ecercicis.exerciciEnum;

public enum Billete implements MonedaBillete {
    CINCO_EUROS(5), DIEZ_EUROS(10), VEINTE_EUROS(20), CINCUENTA_EUROS(50), CIEN_EUROS(100), DOSCIENTOS_EUROS(200),
    QUINIENTOS_EUROS(500);

    private double valor;

    Billete(int s) {// constructor de la classe
        valor = s;
    }

    double getValor() {
        return valor;
    }

    @Override
    public double calcularImporte(int n) {

        double valorCalculado = this.getValor() * n;

        return valorCalculado;

    }
}
