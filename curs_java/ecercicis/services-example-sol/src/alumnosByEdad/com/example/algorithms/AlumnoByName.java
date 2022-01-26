package com.example.algorithms;

import java.util.Comparator;

import com.example.modelos.Alumno;
import com.example.services.EstrategiaOrdenacion;

public class AlumnoByName implements EstrategiaOrdenacion {
    
    public Comparator<Alumno> getAlgoritmo(Sentido sentido) {
        if(sentido == EstrategiaOrdenacion.Sentido.ASC) {
            return (alum1, alum2) -> alum1.getNombres().compareTo(alum2.getNombres());
        } else {
            return (alum1, alum2) -> -alum1.getNombres().compareTo(alum2.getNombres());
        }
    }
}
