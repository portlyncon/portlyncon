package curs_java.Universitat.practica2.EstatuetSalmeronIsaac_POO_Praactica2.src;

/*
 * Group.java
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
/**
 * classe Group, declarem les variables necessaries per la classe
 */

public class Group extends Artist {

    public int yearStarted;

    /**
     * Metode constructor de la classe, inicialitzem la variable yearStarted i
     * cridem al metode constructor de la superclasse
     */

    public Group(int code, String name, int yearStarted) {

        super(code, name);
        this.yearStarted = yearStarted;
    }

    /**
     * Metode que retorna yearStared en un int
     */

    public int getYearStarted() {
        return this.yearStarted;
    }

    /**
     * Metode que estableix el yearStarted
     */

    public void setYearStarted(int yearStarted) {
        this.yearStarted = yearStarted;
    }

    /**
     * Metode toString per retornar un String amb les caracteristiques necessaries
     * requerides per l'enunciat de la practica fa una crida al metode toString de
     * la superclasse
     */

    public String toString() {
        return (super.toString() + "yearStarted :" + this.yearStarted);
    }
}
