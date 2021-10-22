/*
 * User.java
 *
 * Created on 18 de mayo de 2009, 12:36
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

/** classe User, declarem les variables necessaries per la classe
 */

public class User {
    
    public String userID;
    public String name;
    public List<AudioClip> audioclips;
    public List<Artist> favorits;
    public List<Rating> ratings;
    public List<NonFreeAudioClip> nonfreeaudioclips;
    
    /** Metode constructor de la classe, inicialitzem les variables userID, name, audioclips, favorits, ratings, nonfreeaudioclips
     */
    
    public User(String userId,String name) {
        
        this.userID = userId;
        this.name =  name;
        this.audioclips = new ArrayList<AudioClip>();
        this.favorits = new ArrayList<Artist>();
        this.ratings = new ArrayList<Rating>();
        this.nonfreeaudioclips = new ArrayList<NonFreeAudioClip>();
    }
    
    /** Metode per afeguir un Audiclip, si l'Audioclip ja s'ha afeguit llancem una UltimaFMException
     */
    
    public void addAudioClip(AudioClip audioclip)  throws UltimaFMException {
        
        if(!audioclips.contains(audioclip)){
            audioclips.add(audioclip);
            
        }else
            throw new UltimaFMException(UltimaFMException.AUDIO_CLIP_ALREADY_ADDED);
    }
    
    /** Metode per afeguir un Artista favorit, si ja s'ha afeguit llencem una UltimaFMException
     */
    
    public void addFavorite(Artist artist) throws UltimaFMException {
        
        if(!favorits.contains(artist)){
            favorits.add(artist);
            
        }else
            throw new UltimaFMException(UltimaFMException.FAVORITE_ALREADY_ADDED);
    }
    
    /** Metode per afeguir una votacio
     */
    
    public void addRate(AudioClip audioclip , int value){
        
    }
    
    /** Metode per evaluar si dos objectes de la classe son iguals, si ho son retornem un true si no un false
     */
    
    public boolean equals(Object o) {
        boolean isEqual = false;
        
        if(this == o){
            isEqual = true;
        }else if (o instanceof User){
            User that = (User) o;
            isEqual = (this.userID).equals(that.userID);
        }
        return isEqual;
    }
    
    /** Metode toString per retornar un String amb les caracteristiques necessaries requerides per l'enunciat de la practica
     */
    
    public String toString(){
        
        StringBuffer s = new StringBuffer();
        s.append(this.name);
        return s.toString();
    }
    
    /** Metode que retorna un List<Artist> que son el artistes favorits del user
     */
    
    public List<Artist> getFavorites(){
        return this.favorits;
    }
    
    /** Metode que retorna un List<AudioClip> dels Audioclips preferits del user
     */
    
    public List<AudioClip> getPersonalCollection(){
        return this.audioclips;
    }
    
    /** Metode que retorna un List<Rating> dels ratings fets pel user
     */
    
    public List<Rating> getRating(){
        return this.ratings;
    }
    
    /** Metode que retorna un List<NonFreeAudioClips> dels Audioclips comprats pel user
     */
    
    public List<NonFreeAudioClip> getPurchases(){
        return this.nonfreeaudioclips;
    }
    
    /** Metode que retorna el UserId en un String
     */
    
    public String getUserId(){
        return this.userID;
    }
    
    /** Mewtode que estableix el userID
     */
    
    public void setUserId(String userid){
        this.userID = userid;
    }
    
    /** Metode que retorna el name en un String
     */
    
    public String getName(){
        return this.name;
    }
    
    /** Metode que estableix el name
     */
    
    public void setName(String name) {
        this.name = name;
    }
    
}







