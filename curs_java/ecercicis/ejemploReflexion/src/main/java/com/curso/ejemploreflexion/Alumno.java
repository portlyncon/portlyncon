/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.ejemploreflexion;

import com.curso.ejemploreflexion.customAnnot.MyAnotacion;

/**
 *
 * @author Toni
 */
public class Alumno {

    private int id;
    private String cedula;
    @MyAnotacion
    private String nombres;
    @MyAnotacion(atributo = "valor de attr en apellidos")
    private String apellidos;
    private String nombreCurso;
    private double nota;
    private int edad;

    public Alumno() {

    }

    public Alumno(int id, String cedula, String nombres, String apellidos, String nombreCurso, double nota, int edad) {
        this.id = id;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.nombreCurso = nombreCurso;
        this.nota = nota;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return this.getId() + " | " + this.getCedula() + " | " + this.getNombres() + " | " + this.getApellidos() + " | Cursos: " + this.getNombreCurso() + " | Nota: " + this.getNota() + " | Edad: " + this.getEdad();
    }

}