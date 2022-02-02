/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

/**
 *
 * @author srpopo
 */
import java.util.Comparator;
import modelos.Alumno;

public interface EstrategiaOrdenacion {
    public enum Sentido { ASC, DESC }

    default public Comparator<Alumno> getAlgoritmo(){
        return this.getAlgoritmo(Sentido.ASC);
    }
    public Comparator<Alumno> getAlgoritmo(Sentido sentido);
}
