package com.mycompany.provagitnetbeans;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlumnoMulticurso extends Alumno {
    private List<String> nombreCursos = new ArrayList<>();
	
	public AlumnoMulticurso() {
		
	}
	public AlumnoMulticurso(int id, String cedula, String nombres, String apellidos, String nombreCurso, double nota, int edad) {
		super(id, cedula, nombres, apellidos, null, nota, edad);
		this.nombreCursos.add(nombreCurso);
	}
	public AlumnoMulticurso(int id, String cedula, String nombres, String apellidos, List<String> nombreCursos, double nota, int edad) {
		super(id, cedula, nombres, apellidos, null, nota, edad);
		this.setNombreCursos(nombreCursos);
	}
 
	public List<String> getNombreCursos() {
		return nombreCursos;
	}
 
	public void setNombreCursos(List<String> nombreCursos) {
		this.nombreCursos = nombreCursos;
	}
	
	public String getNombreCursosStr(){
		return this.getNombreCursos().stream().collect(Collectors.joining(", "));
	}
	
	@Override
	public String toString() {
		return this.getId()+" | "+this.getCedula()+" | "+this.getNombres()+" | "+this.getApellidos()+" | Cursos: "+this.getNombreCursosStr()+" | Nota: "+this.getNota()+" | Edad: "+this.getEdad();
	}

}
