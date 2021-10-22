/*
 * MusicalPiece.java
 *
 * Created on 18 de mayo de 2009, 12:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 *
 * @author srpopo
 */

/** classe MusicalPiece, declarem les variables necessaries per la classe
 */
public class MusicalPiece implements Comparable<MusicalPiece> {
    
    public int code;
    public String name;
    public double average;
    public double numvots;
    public List<Artist>   Composer;
    public List<AudioClip> Audioclips;
    public List<Category> Categories;
    
    private static String NL = (System.getProperty("line.separator"));
    
    /** Metode constructor de la classe, inicialitzem les variables code, name, List<Artist> composer, average, numvots
     */
    
    public MusicalPiece(int code, String name,List<Artist> composer) {
        this.code = code;
        this.setName(name);
        this.Composer = new ArrayList<Artist>(composer);
        this.Audioclips = new ArrayList<AudioClip>();
        this.Categories = new ArrayList<Category>();
        this.average = 0.0;
        this.numvots = 0.0;
    }
    
    /** Metode per afeguir un compositor, si el compositor ja existeix llencem una UltimaFMException
     */
    
    public void addComposer(Artist composer) throws UltimaFMException {
        
        if(!Composer.contains(composer)){
            Composer.add(composer);
            
        }else
            throw new UltimaFMException(UltimaFMException.COMPOSER_IS_ALREADY_ADDED);
    }
    
    /** Metode per afeguir un AudioClip
     */
    
    public void addAudioClip(AudioClip audioclip){
        Audioclips.add(audioclip);
    }
    
    /** Metode per afeguir una catergoria
     */
    
    public void addCategories(Category categoria){
        Categories.add(categoria);
    }
    
    /** Metode que retorna un List<Artist> composer
     */
    
    public List<Artist> getComposer(){
        return this.Composer;
    }
    
    /** Metode que retorna un List<AudioClip>
     */
    
    public List<AudioClip> getAudioCLips(){
        return this.Audioclips;
    }
    
    /** Metode per evaluar si dos objectes de la classe son igual, retorna true si ho son i false si no
     */
    
    public boolean equals(Object o) {
        boolean isEqual = false;
        if(o instanceof Artist){
            MusicalPiece mus = (MusicalPiece) o;
            isEqual= (this.code) == (((MusicalPiece) o).getCode());
        }
        return isEqual;
    }
    
    /** Metode que retorna el code en un int
     */
    
    public int getCode(){
        return this.code;
    }
    
    /** Metode que compara dos objectes de la classe a partir del seu AverageRating, retorna un int segons la seva comparacio
     */
    
    public int compareTo(MusicalPiece o){
        
        int ret ;
        
        ret =((String.valueOf(this.getAverageRating())).compareTo((String.valueOf(o.getAverageRating()))));
        return(ret);
    }
    
    /** Metode que retorna el name en un String
     */
    
    public String getName(){
        return this.name;
    }
    
    /** Metode que estableix el name
     */
    
    public void setName( String name){
        this.name = name;
    }
    
    /** Metode que retorna average en un double
     */
    
    public double getAverage(){
        return this.average;
    }
    
    /** Metode que estableix average
     */
    
    public void setAverage(double aver){
        this.average = average + aver;
    }
    
    /** Metode toString per retornar un String amb les caracteristiques necessaries requerides per l'enunciat de la practica
     */
    
    public String toString(){
        
        Artist found = null;
        String retorn =("");
        
        if(this.Composer.size()>1){
            for (Iterator it = Composer.iterator(); it.hasNext() & found == null;) {
                
                Artist artist = (Artist) it.next();
                retorn = retorn +(artist.toString() + NL);
            }
            return ("name : " + this.getName() + "List of Composers: " + NL + retorn + NL);
        }else{
            
            return ( "name : " + this.getName() + " Unique Composer" + NL + this.Composer.get(0).toString() + NL);
        }
    }
    
    /** Metode que retorna l' AverageRating en un double
     */
    
    public double getAverageRating(){
        return (average / numvots) ;
    }
    
    /** Metode que retorna el List<Category> de l'objecte
     */
    
    public List<Category> getCategories(){
        return this.Categories;
    }
    
}





