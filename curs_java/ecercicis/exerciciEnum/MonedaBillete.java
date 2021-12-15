package curs_java.ecercicis.exerciciEnum;

public interface MonedaBillete {
    double getValor();

    default double calcularImporte(int nElementos) {

        return nElementos * this.getValor();

    }

}
