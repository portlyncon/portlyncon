package com.example.services;

import java.util.Comparator;
import com.example.modelos.Alumno;

public interface EstrategiaOrdenacion {
    public enum Sentido { ASC, DESC }

    default public Comparator<Alumno> getAlgoritmo(){
        return this.getAlgoritmo(Sentido.ASC);
    }
    public Comparator<Alumno> getAlgoritmo(Sentido sentido);
}
