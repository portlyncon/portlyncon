package curs_java.ecercicis.herencia_interfaces2;

import java.util.Date;

public class revista extends consumible {

    int numero_revista;

    public revista(int co, String ti, Date fe, int numero) {

        codigo = co;
        titulo = ti;
        fecha_publicacion = fe;
        numero_revista = numero;

    }

    String devolver_parametros() {

        String cadena = "";
        cadena = ("codigo  " + Integer.toString(codigo) + " titulo  " + titulo + "fecha  "
                + fecha_publicacion.toString() + "numero  " + Integer.toString(numero_revista));
        return cadena;

    }

    Date getDate() {
        return fecha_publicacion;
    }

    int getCodigo() {
        return codigo;
    }
}
