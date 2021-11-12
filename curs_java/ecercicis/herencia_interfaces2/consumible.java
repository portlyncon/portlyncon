package curs_java.ecercicis.herencia_interfaces2;

import java.sql.Date;

public abstract class consumible {

    int codigo;
    String titulo;
    Date fecha_publicacion;

    public consumible() {

    }

    String devolver_atributos() {
        return titulo;

    }

    Date devolver_fecha() {
        return fecha_publicacion;
    }

    int devolver_codige() {
        return codigo;
    }

}
