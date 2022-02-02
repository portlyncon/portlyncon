/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algorithms;

/**
 *
 * @author srpopo
 */
import java.util.Comparator;

import modelos.Alumno;
import services.EstrategiaOrdenacion;


public class AlumnoByName implements EstrategiaOrdenacion {
    
    public Comparator<Alumno> getAlgoritmo(Sentido sentido) {
        if(sentido == EstrategiaOrdenacion.Sentido.ASC) {
            return (alum1, alum2) -> alum1.getNombres().compareTo(alum2.getNombres());
        } else {
            return (alum1, alum2) -> -alum1.getNombres().compareTo(alum2.getNombres());
        }
    }
}