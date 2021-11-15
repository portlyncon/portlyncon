package curs_java.ecercicis.herencia_interfaces3;

public class Profesor extends Personal {

    public Profesor(String nombre, String apellidos, String correo) {

        nombre = nombre;
        apellidos = apellidos;
        correo = correo;

        uni.setProfe(this);

    }

    void asignar_curso() {
        curso.assignar_profesor(this);
    }

    public Curso get_Curso() {

        return this.curso;

    }

}
