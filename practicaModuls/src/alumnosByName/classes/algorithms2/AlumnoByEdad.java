package algorithms2;

import java.util.Comparator;

import modelos.Alumno;
import services.EstrategiaOrdenacion;

public class AlumnoByEdad implements EstrategiaOrdenacion {
    
    public Comparator<Alumno> getAlgoritmo(Sentido sentido) {
        if(sentido == EstrategiaOrdenacion.Sentido.ASC) {
            return (alum1, alum2) -> alum1.getEdad() - alum2.getEdad();
        } else {
            return (alum1, alum2) -> alum2.getEdad() - alum1.getEdad();
        }
    }
}
