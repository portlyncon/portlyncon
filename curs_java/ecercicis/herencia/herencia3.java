package curs_java.ecercicis.herencia;

abstract class ClasseA {// no es pot instanciar no esta obligada a implemetar res

    // public
    // protected
    //
    // private

    abstract void foo();// metode abstracte te que estar en classe abstracta

    abstract ClasseA foo2(ClasseA ca);

    void fooNoAbtract() {
        System.out.println("fooNoAbtract");
        foo();
    }

}

class ClasseB extends ClasseA {

    @Override
    void foo() {
        // TODO Auto-generated method stub

    }

    ClasseA foo2(ClasseA ca) {// sobrecarrega

        return null;// sobreescriure el metode, especifiquem els tipus sortida
    }
}

abstract class ClasseC extends ClasseB {

}

public class herencia3 {

    public static void main(String[] args) {
        // new Classe1(); //no podem instancias la Classe A pq es abstracta
    }
}
