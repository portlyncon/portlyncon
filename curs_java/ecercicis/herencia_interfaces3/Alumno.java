package curs_java.ecercicis.herencia_interfaces3;

public class Alumno extends Personal {

    public Alumno(String nombre, String apellidos, String correo) {

        nombre = nombre;
        apellidos = apellidos;
        correo = correo;

    }

    public String getNombre() {

        return nombre;
    }

    public boolean equals(Object o) {

        boolean isEqual = false;
        if (o instanceof Alumno) {
            Alumno it = (Alumno) o;
            isEqual = (this.getName()) == (((Alumno) o).getName());
        }
        return isEqual;
    }

    Object getName() {
        return this;
    }
}
