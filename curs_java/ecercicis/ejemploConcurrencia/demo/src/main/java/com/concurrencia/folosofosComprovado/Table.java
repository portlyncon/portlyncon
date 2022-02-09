/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.folosofosComprovado;
//import java.util.logging.Level;

//import java.util.logging.Logger;

public class Table {

    public synchronized void take(Fork left, Fork right) {

        while (left.isInUse() || right.isInUse()) {
            waiting();
        }

        left.take();
        right.take();
    }

    public synchronized void leave(Fork left, Fork right) {
        left.leave();
        right.leave();
        notifyAll();
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException ex) {
            // Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
