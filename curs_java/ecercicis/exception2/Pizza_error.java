package curs_java.ecercicis.exception2;

import java.io.PrintStream;

public class Pizza_error extends IllegalArgumentException {

    public static final String pizza_error = "La Pizza solicitada no existe";
    public static final String tooMuchCheeseError = "el numero introducido no es un entero";

    public Pizza_error(String fueraRango) {
        super(String.valueOf(fueraRango));
    }

    public PrintStream getOut() {
        return null;
    }

}
