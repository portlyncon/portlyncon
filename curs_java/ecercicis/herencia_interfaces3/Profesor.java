package curs_java.ecercicis.herencia_interfaces3;

import java.util.Collections;

public class Profesor extends Personal {

    public Profesor(String nombre, String apellidos, String correo, Curso cur) {

        nombre = nombre;
        apellidos = apellidos;
        correo = correo;

    }

    public String getNombre() {

        return nombre;
    }

    public boolean equals(Object o) {

        boolean isEqual = false;
        if (o instanceof Profesor) {
            Profesor it = (Profesor) o;
            isEqual = (this.getName()) == (((Alumno) o).getName());
        }
        return isEqual;
    }

    private Object getName() {
        return this;
    }
}
