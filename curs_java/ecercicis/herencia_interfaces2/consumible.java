package curs_java.ecercicis.herencia_interfaces2;

import java.util.Date;

public abstract class consumible {

    int codigo;
    String titulo;
    Date fecha_publicacion;

    public consumible() {

    }

    String devolver_atributos() {
        return titulo;

    }

    Date getDate() {
        return fecha_publicacion;
    }

    int getCodigo() {
        return codigo;
    }

}
