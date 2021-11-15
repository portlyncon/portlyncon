package curs_java.ecercicis.herencia_interfaces3;

public class Alumno extends Personal {
    public Alumno(String nombre, String apellidos, String correo) {

        nombre = nombre;
        apellidos = apellidos;
        correo = correo;

        uni.setAlumno(this);

    }

    void asignar_Curso() {

        curso.assignar_alumnos(this);
    }

    public Curso get_Curso() {

        return this.curso;

    }
}
