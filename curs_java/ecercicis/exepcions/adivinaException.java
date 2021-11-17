package curs_java.ecercicis.exepcions;

public class adivinaException extends IllegalArgumentException {

    public static final int ACIERTO = 0;
    public static final int MAYOR = 1;
    public static final int MENOR = -1;
    public static final String fuera_rango = "el numero introducido esta fuera del rango";
    public static final String no_entero = "el numero introducido no es un entero";

    public adivinaException(String fueraRango) {
        super(String.valueOf(fueraRango));
    }

}
