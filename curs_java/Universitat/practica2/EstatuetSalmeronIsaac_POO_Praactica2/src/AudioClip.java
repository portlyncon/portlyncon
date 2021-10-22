/*
 * AudioClip.java
 *
 * Created on 18 de mayo de 2009, 12:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author srpopo
 */

/** classe AudioClip, declarem les variables reuqerides per aquesta classe
 */

public class AudioClip {
    
    public List<Artist>   Interpreters;
    public List<Rating>   Ratings;
    public List<User> Users;
    public String code;
    public int duration;
    public int votacions;
    public MusicalPiece musicalpiece;
    
    private static String NL = (System.getProperty("line.separator"));
    
    /** Metode constructor de la classe, inicialitzem les variables code,musicalpiece,duration, interpreters,Ratings i Users
     */
    
    public AudioClip( String code,int duration,MusicalPiece musicalpiece, List<Artist> interpreters ) {
        
        this.code = code;
        this.musicalpiece = musicalpiece;
        this.duration = duration;
        this.Interpreters = interpreters;
        this.Ratings = new ArrayList<Rating>();
        this.Users = new ArrayList<User>();
    }
    
    /** Metode per afeguir a la classe un interpret, si l'interpret ja existeix llencem una UltimaFMException
     */
    
    public void addInterpreter(Artist interpreter) throws UltimaFMException {
        if(!Interpreters.contains(interpreter)){
            Interpreters.add(interpreter);
            
        }else{
            throw new UltimaFMException(UltimaFMException.INTERPRETER_IS_ALREADY_ADDED);
        }
    }
    
    /** Metode equals per evaluar si dos objectes de la classe son iguals, retornme true si son igual i false si no
     */
    
    public boolean equals(Object o) {
        boolean isEqual = false;
        
        if(this == o){
            AudioClip aud = (AudioClip) o;
            isEqual = this.getCode().equals(aud.getCode());
        }else if (o instanceof NonFreeAudioClip){
            NonFreeAudioClip that = (NonFreeAudioClip) o;
            isEqual = (this.getCode()).equals(that.getCode());
        }
        return isEqual;
    }
    
    /** Metode per obtenir el code de la classe, retornem un String amb el code
     */
    
    public String getCode(){
        return this.code;
    }
    
    /** Metode toString per retornar un String amb les caracteristiques necessaries requerides per l'enunciat de la practica
     *  distinguim entre un interpret o mes d'un
     */
    
    public String toString(){
        
        StringBuffer s = new StringBuffer();
        s.append("name MusicalPiece: " + musicalpiece.getName()+" ");
        s.append("duration: " +" "+ String.valueOf(this.duration)+" ");
        
        if(Interpreters.size() >1){
            s.append("List of Interpreters:"+NL);
            for(Artist art : Interpreters){
                s.append(art.toString());
            }
        }else{
            s.append("Unique Interpreter:" +NL);
            s.append(Interpreters.get(0).toString());
        }
        return s.toString();
    }
    
    /** Metode que retona un List<Rating> de l'objecte de la classe
     */
    
    public List<Rating> getRatings(){
        return this.Ratings;
    }
    
    /** Metode que retorna la duracio de l'AudioClip en un int
     */
    
    public int getDuration(){
        return this.duration;
    }
    
    /** Metode que estableix la duracio d'AudioClip
     */
    
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    /** Metode que retorna la MusicalPiece a la que pertany l'AudioClip
     */
    
    public MusicalPiece getMusicalPiece(){
        return this.musicalpiece;
    }
    
    /** Metode que estableix la MusicalPiece a la que pertany l'AudioClip
     */
    
    public void setMusicalPiece(MusicalPiece musicalpiece){
        this.musicalpiece = musicalpiece;
    }
    
    /** Metode per afeguir una votacio,
     */
    
    public void addRate(User user,int value){
        
        votacions = votacions + value;
    }
    
    /** Metode que retorna el avergarating del la classe
     */
    
    public double getAverageRating(){
        
        double c = 0.0;
        int a = Ratings.size();
        c = votacions / a;
        
        return(c);
    }
    
}



