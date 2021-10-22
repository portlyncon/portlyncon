/*
 * Rating.java
 *
 * Created on 18 de mayo de 2009, 12:36
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author srpopo
 */

/** classe Rating, declarem les variables necessaries
 */

public class Rating {
    
    public AudioClip audioclip;
    public User user;
    public int value;
    
    /** constructor de la classe, inicialitzem les variables audioclip, user, value
     */
    
    public Rating(AudioClip audioclip, User user, int value) {
        
        this.audioclip = audioclip;
        this.user = user;
        this.value = value;
    }
    
    /** metode per evaluar si dos objectes de la classe son iguals amb els parametres audiclip i user
     * retorna true si son iguals i flase si no
     */
    
    public boolean equals(Object o) {
        boolean isEqual = false;
        
        if(o instanceof Artist){
            Rating ar = (Rating) o;
            isEqual = (this.getAudioClip()).equals(ar.getAudioClip()) & (this.getUser()).equals(ar.getUser());
        }
        return isEqual;
    }
    
    /** Metode que retorna el user
     */
    
    public User getUser(){
        return this.user;
    }
    
    /** Metode que retorna l'AudioClip
     */
    
    public AudioClip getAudioClip(){
        return this.audioclip;
    }
    
    /** Metode que retorna el value
     */
    
    public int getValue(){
        return this.value;
    }
    
}
