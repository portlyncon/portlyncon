package curs_java.ecercicis.exepcions;

public class Adivina {

    public static final int LIMITE_MAYOR = 499;
    public static final int LIMITE_MENOR = 1;
    int numero;

    public Adivina() {
        int numero = (int) (Math.random() * LIMITE_MAYOR + LIMITE_MENOR);
    }

    public int adivina(String num) throws adivinaException {

        int numi = Integer.parseInt(num);

        if (numi == numero) {
            throw new adivinaException(adivinaException.ACIERTO);
        } else {
            if (numi < numero) {
                throw new adivinaException(adivinaException.MENOR);
            }
            throw new adivinaException(adivinaException.MAYOR);
        }

    }

}
