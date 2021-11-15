package curs_java.ecercicis.herencia_interfaces3;

public class Alumno extends Personal {

    public Alumno(String nombre, String apellidos, String correo) {

        nombre = nombre;
        apellidos = apellidos;
        correo = correo;

        uni.setAlumno(this);

    }

    public String getNombre() {

        return nombre;
    }

    void matricular_Curso() {

        curso.assignar_alumnos(this);
    }

    public Curso get_Curso() {

        return this.curso;

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
