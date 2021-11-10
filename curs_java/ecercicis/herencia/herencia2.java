
package curs_java.ecercicis.herencia;

public class herencia2 {

}

class Classe1 {

    // aqui es carrega en el stack perque te static, es una zona de memoria que no
    // es borra i es carrega la classe
    static {
        System.out.println("estatic classe1");
    }

    public Classe1(String s2) {// constructor de la classe

        System.out.println("classe1");
    }

}

class Classe2 extends Classe1 {

    static {

        System.out.println("estatic classe2");
    }

    {
        System.out.println("instancia classe2");
    }

    public Classe2(String s2) {
        super("ssssssssss");// obligats a fer la implementacio del constructor pare

    }

}
