package curs_java.ecercicis.herencia_interfaces2;

import java.util.Date;

public class libro extends consumible implements interface_prestable {

    boolean prestado = false;

    public libro(int co, String ti, Date i) {

        codigo = co;
        titulo = ti;
        fecha_publicacion = i;

    }

    String devolver_parametros() {

        String cadena = "";
        cadena = (Integer.toString(codigo) + " " + titulo + " " + fecha_publicacion.toString());
        return cadena;

    }

    Date getDate() {
        return fecha_publicacion;
    }

    int getCodigo() {
        return codigo;
    }

    boolean getPrestado() {
        return prestado;
    }

    @Override
    public void prestar() {
        // TODO Auto-generated method stub
        prestado = true;
    }

    @Override
    public void devolver() {
        // TODO Auto-generated method stub
        prestado = false;
    }

    @Override
    public void prestado() {
        // TODO Auto-generated method stub

    }

}
