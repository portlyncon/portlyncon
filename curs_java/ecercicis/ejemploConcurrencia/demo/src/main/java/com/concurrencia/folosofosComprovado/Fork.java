/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.folosofosComprovado;

public class Fork {

    private boolean inUse = false;

    public void take() {
        this.inUse = true;
    }

    public void leave() {
        this.inUse = false;
    }

    public boolean isInUse() {
        return this.inUse;
    }
}
