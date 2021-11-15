package curs_java.ecercicis.herencia_interfaces3;

import java.util.ArrayList;

public class Universidad {

    ArrayList<Alumno> llistat_alumnes;
    ArrayList<Profesor> llistat_profes;
    ArrayList<Curso> llistat_cursos;
    String Nombre;

    public Universidad(String nombre) {

        Nombre = nombre;
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
        if (!llistat_alumnes.contains(alu)) {
            llistat_alumnes.add(alu);
            System.err.println("afeguit Alumne");
        } else
            System.err.println("ja existeix aquest Alumne");

    }

    void setProfe(Profesor profe) {
        if (!llistat_profes.contains(profe)) {
            llistat_profes.add(profe);
            System.err.println("afeguit Professor");
        } else
            System.err.println("ja existeix aquest Professor");

    }

    void setCurso(Curso cur) {
        if (!llistat_cursos.contains(cur)) {
            llistat_cursos.add(cur);
            System.err.println("afeguit Curs");
        } else
            System.err.println("ja existeix aquest Curs");

    }

}
