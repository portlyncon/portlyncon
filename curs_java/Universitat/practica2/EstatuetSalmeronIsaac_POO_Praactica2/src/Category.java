/*
 * Category.java
 *
 * Created on 18 de mayo de 2009, 12:35
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 *
 * @author srpopo
 */

/** Classe Category, creem les variables necessaries per la classe
 */


public class Category {
    
    public int categoryId;
    public String name;
    public List<Category> categorys;
    public List<MusicalPiece> musicalpieces;
    
    private static String NL = (System.getProperty("line.separator"));
    
    /** Metode constructor de la classe, inicialitzem les variables categoryid,name,categorys i musicalpieces
     */
    
    public Category(int categoryid, String name) {
        
        this.categoryId = categoryid;
        this.name = name;
        this.categorys = new ArrayList<Category>();
        this.musicalpieces = new ArrayList<MusicalPiece>();
    }
    
    /** Metode que retorna la CategoryId
     */
    
    public int getCategoryId(){
        return this.categoryId;
    }
    
    /** Metode que retorna un List<Category> de les categories dependents de l'objecte
     */
    
    public List<Category> getDependencies(){
        return this.categorys;
    }
    
    /** Metode que retorna un List<MusicalPiece> de les MusicalPiece que tenen aquesta categoria
     */
    
    public List<MusicalPiece> getMusicalPieces(){
        return this.musicalpieces;
    }
    
    /** Metode que retorna un striong amb les MusicalPiece de la categoria oredenades per les votacions
     */
    
    public String getMusicalPiecesByAverageRating(){
        Collections.sort(this.getMusicalPieces());
        StringBuffer s = new StringBuffer();
        for(MusicalPiece musicalpiece : musicalpieces){
            s.append(musicalpiece.toString());
        }
        return s.toString();
    }
    
    /** Metode toString per retornar un String amb les caracteristiques necessaries requerides per l'enunciat de la practica
     */
    
    public String toString(){
        StringBuffer s = new StringBuffer();
        s.append(this.name+NL);
        if(categorys.size()>0){
            s.append("Dependents:");
            for (Category cat: categorys){
                s.append(cat.toString() + NL);
            }
        }
        return s.toString();
    }
}

