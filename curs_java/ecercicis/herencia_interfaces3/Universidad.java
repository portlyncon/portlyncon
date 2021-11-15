package curs_java.ecercicis.herencia_interfaces3;

import java.util.ArrayList;

public class Universidad {

    ArrayList<Alumno> llistat_alumnes; 
    ArrayList<Profesor> llistat_profes; 
    ArrayList<Curso> llistat_cursos; 

    public  Universidad() {
        ArrayList<Alumno> llistat_alumnes = new ArrayList<>();
        ArrayList<Profesor> llistat_profes = new ArrayList<>();
        ArrayList<Curso> llistat_cursos = new ArrayList<>();
    
    }

    public String listar_alumnos() {

        return llistat_alumnes.toString();
    }

    public String listar_profes() {

        return llistat_profes.toString();
    }

    public String listar_cursos() {

        return llistat_cursos.toString();
    }

    void setAlumno(Alumno alu) {

        llistat_alumnes.add(alu);
    }

    void setProfe(Profesor profe) {

        llistat_profes.add(profe);
    }

    void setCurso(Curso cur) {

        llistat_cursos.add(cur);
    }

}
