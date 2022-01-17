/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curs_java.ecercicis.exemples_lambda;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelssanchez
 */
public class AlumnoMulticurso extends Alumno {

    List<String> ListaCursos;

    public AlumnoMulticurso(int id, String cedula, String nombres, String apellidos, List nombreCurso,
            double nota, int edad) {
        this.ListaCursos = new ArrayList();
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ListaCursos = nombreCurso;
        this.nota = nota;
        this.edad = edad;
    }

    public AlumnoMulticurso(int id, String cedula, String nombres, String apellidos, String nombreCurso,
            double nota, int edad) {
        this.ListaCursos = new ArrayList();
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreCurso = nombreCurso;
        this.nota = nota;
        this.edad = edad;
    }

    public String getNombreCurso() {

        if (this.ListaCursos.isEmpty()) {

            return nombreCurso;
        }
        return ListaCursos.toString();
    }

    public String toString() {

        if (this.ListaCursos.isEmpty()) {
            return id + " | " + cedula + " | " + nombres + " | " + apellidos + " | Curso: " + nombreCurso + " | Nota: "
                    + nota + " | Edad: " + edad;
        }
        return id + " | " + cedula + " | " + nombres + " | " + apellidos + " | Curso: " + ListaCursos.toString()
                + " | Nota: " + nota + " | Edad: " + edad;

    }

}
