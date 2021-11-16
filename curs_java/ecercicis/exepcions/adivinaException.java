package curs_java.ecercicis.exepcions;

public class adivinaException extends IllegalArgumentException {

    public static final int ACIERTO = 0;
    public static final int MAYOR = 1;
    public static final int MENOR = -1;

    public adivinaException(String mes) {
        super(mes);
    }

}
