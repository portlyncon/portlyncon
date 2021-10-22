/*
 * NonFreeAudioClip.java
 *
 * Created on 18 de mayo de 2009, 12:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.util.List;
/**
 *
 * @author srpopo
 */

/** classe NonFreeAudioClip, declarem la variable necessari
 */
public class NonFreeAudioClip extends AudioClip {
    
    public double price;
    
    /** Metode constructor de la classe, inicialitzem la variable price i cridem al constructor de la superclasse
     */
    
    public NonFreeAudioClip(String code,int duration,MusicalPiece musicalpiece, List<Artist> interpreters,double price) {
        
        super(code,duration,musicalpiece,interpreters);
        this.price = price;
    }
    
    /** Metode toString per retornar un String amb les caracteristiques necessaries requerides per l'enunciat de la practica
     * cridem al metode toString de la superclasse
     */
    
    public String toString(){
        return("MusicPiece NonFreeOfCharge price: " + this.price +" " + super.toString());
    }
    
}
