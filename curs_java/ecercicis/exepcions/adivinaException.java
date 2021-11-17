package curs_java.ecercicis.exepcions;

import java.io.PrintStream;

public class adivinaException extends IllegalArgumentException {

    public static final String fuera_rango = "el numero introducido esta fuera del rango";
    public static final String no_entero = "el numero introducido no es un entero";

    public adivinaException(String fueraRango) {
        super(String.valueOf(fueraRango));
    }

    public PrintStream getOut() {
        return null;
    }

}
