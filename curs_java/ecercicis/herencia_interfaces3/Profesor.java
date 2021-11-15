package curs_java.ecercicis.herencia_interfaces3;

import java.util.Collections;

public class Profesor extends Personal {

    public Profesor(String nombre, String apellidos, String correo, Curso cur) {

        nombre = nombre;
        apellidos = apellidos;
        correo = correo;

        uni.setProfe(this);

    }

    public void asignar_curso() {
        curso.assignar_profesor(this);
    }

    public String getNombre() {

        return nombre;
    }

    public Curso get_Curso() {

        return this.curso;

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
