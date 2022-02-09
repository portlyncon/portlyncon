package curs_java.ecercicis.ejemploConcurrencia.demo.src.main.java.com.concurrencia.filosofos;

import java.util.ArrayList;

public class Fork {

    boolean tenedorDerecho;
    boolean tenedorIzquierda;

    public Fork() {
        this.tenedorDerecho = false;
        this.tenedorIzquierda = false;
    }

    public ArrayList<Boolean> take(int a) {

        ArrayList<Boolean> lst = new ArrayList<Boolean>();
        if (a == 0) {
            lst.add(tenedorDerecho = true);
        } else
            lst.add(tenedorIzquierda = true);

        return lst;

    }

    public ArrayList<Boolean> leave(int a) {

        ArrayList<Boolean> lst = new ArrayList<Boolean>();

        if (a == 0) {
            lst.add(tenedorDerecho = false);
        } else
            lst.add(tenedorIzquierda = false);

        return lst;

    }

}
