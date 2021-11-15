package curs_java.ecercicis.herencia_interfaces3;

import java.util.Date;
import java.util.ArrayList;

public class Curso {

    int codigo;
    String nombre;
    Date fecha_inicia;
    Date fecha_fin;
    Profesor profe;
    ArrayList<Alumno> llistat_alumnes = new ArrayList<>();
    Universidad uni;

    public Curso(int codigo, String nombre, Date fecha_inicio, Date fecha_fin) {

        uni.setCurso(this);

    }

    void assignar_profesor(Profesor profe) {

        this.profe = profe;
    }

    void assignar_alumnos(Alumno alumno) {

        llistat_alumnes.add(alumno);
    }

}
