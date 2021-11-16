package curs_java.ecercicis.exepcions;

public class Adivina {

    public static final int LIMITE_MAYOR = 1;
    public static final int LIMITE_MENOR = 500;

    public Adivina() {

    }

    public int adivina(String num) throws adivinaException {

        throw new adivinaException(String.valueOf(adivinaException.ACIERTO));
    }

}
