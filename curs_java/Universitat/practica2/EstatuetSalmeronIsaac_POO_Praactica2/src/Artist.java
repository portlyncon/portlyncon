package curs_java.Universitat.practica2.EstatuetSalmeronIsaac_POO_Praactica2.src;

/*
 * Artist.java
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

/**
 * classe Artis,creem les variables necessaries per la classe Artist
 */
public class Artist {

    public int code;
    public String name;
    public boolean Composer;
    public boolean Interpreter;

    /**
     * Metode constructor de la classe, inicialitzem les variables code i name
     */

    public Artist(int code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * Metode per comprobar la igualtat de la classe Artist, returnem un boolea en
     * true si son iguals i un false si no
     */

    public boolean equals(Object o) {

        boolean isEqual = false;
        if (o instanceof Artist) {
            Artist ar = (Artist) o;
            isEqual = (this.code) == (((Artist) o).getCode());
        }
        return isEqual;
    }

    /**
     * Metode per retornar el code de la classe, retornem un int que representa el
     * code de la classe
     */

    public int getCode() {
        return this.code;
    }

    /**
     * Metode per retornar el name de la classe, retornem un String que representa
     * el name de la classe
     */

    public String getName() {
        return this.name;
    }

    /**
     * Metode per retornar si es composer, returnem un boolea en true si ho es i un
     * false si no ho es
     */

    public boolean isComposer(String composer) {

        return Composer;
    }

    /**
     * Metode per retornar si es interpreter, returnem un boolea en true si ho es i
     * un false si no ho es
     */

    public boolean isInterpreter(String interpreter) {

        return Interpreter;
    }

    /**
     * Metode per especificar que l'Artista es un interpreter
     */

    public void setInterpreter(boolean interpreter) {
        Interpreter = interpreter;
    }

    /**
     * Metode per especificar que l'Artista es un Composer
     */

    public void setComposer(boolean composer) {
        Composer = composer;
    }

    /**
     * Metode toString per retornar un String amb les caracteristiques necessaries
     * requerides per l'enunciat de la practica
     */

    public String toString() {
        return ("artist code: " + this.code + "  " + "name: " + this.name);
    }

}
