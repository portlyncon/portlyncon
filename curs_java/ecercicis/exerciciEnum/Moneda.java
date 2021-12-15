package curs_java.ecercicis.exerciciEnum;

public enum Moneda implements MonedaBillete {
    CENTIMO(0.01), DIEZ_CENTIMOS(0.10), VEINTE_CENTIMOS(0.20), CINCUENTA_CENTIMOS(0.50), UN_EURO(1.0), DOS_EUROS(2.0);

    private final double valor;

    Moneda(double s) {// constructor de la classe
        valor = s;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public double calcularImporte(int n) {

        double valorCalculado = this.getValor() * n;

        return valorCalculado;

    }

}
