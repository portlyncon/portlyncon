/*
 * IndividualArtist.java
 *
 * Created on 18 de mayo de 2009, 12:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author srpopo
 */

/** classe IndividualArtist, declarem les variables necessaries per la classe
 */

public class IndividualArtist extends Artist{
    
    public int birthYear;
    public int deceaseYear;
    
    /** Metode constructor de la classe, inicialitzem les variables birthYear i deceaseYer, cridem al constructor de la superclasse
     */
    
    public IndividualArtist( int code,String name,int birthYear,int deceaseYer) {
        
        super(code,name);
        
        this.birthYear = birthYear;
        this.deceaseYear = deceaseYear;
    }
    
    /** Metode constructor de la classe, inicialitzem les variables birthYear i deceaseYer, cridem al constructor de la superclasse
     */
    
    public IndividualArtist( int code,String name,int birthYear) {
        super(code,name);
        
        this.birthYear = birthYear;
        this.deceaseYear = 0;
    }
    
    /** Metode que retorna la variable birthYear en un int
     */
    
    public int getBirthYear(){
        return this.birthYear;
    }
    
    /** Metode que retorna la variable deceaseYear en un int
     */
    
    public int getDeceaseYear(){
        return this.deceaseYear;
    }
    
    /** Metode que estableix la variable birthYear
     */
    
    public void setBirthYear( int birthYear){
        this.birthYear = birthYear;
    }
    
    /** Metode que estableix la variable birthYear
     */
    
    public void setDeceaseYear( int deceaseYear){
        this.deceaseYear = deceaseYear;
    }
    
    /** Metode toString per retornar un String amb les caracteristiques necessaries requerides per l'enunciat de la practica
     *  fa una crida al metode toString de la superclasse
     */
    
    public String toString(){
        
        if(deceaseYear != 0)
            return(super.toString() + "birthYear: " + this.birthYear  + "deceaseYear: " + this.deceaseYear);
        else
            
            return(super.toString() + "birthYear: " + this.birthYear  +  "deceaseYear: Still Alive"  );
    }
    
}

