package curs_java.ecercicis.herencia;

public class herencia1 {

    public static void main(String[] args) {
        A a = new A();
        a.runFoo();

        B b = new B();

        b.runFoo();

        A ab = new B();
        ab.runFoo();
        ((B) ab).fooB();// casting per accedir al metode fooB perque ab estava definit amb la classe A

        metodo1(a);

        B bnull = null;

        System.out.println(null instanceof Object); // siempre False por que referencia null

        B nNoNull = new B();
        System.out.println(nNoNull instanceof Object); // siempre True, referencia no nula

        // System.out.println(nNoNull instanceof String);// no compila nNoNull no pot
        // ser mai String perque String es "Finale" no object
    }

    private static void metodo1(A a) {
        a.runFoo();
        if (a instanceof B) { // s'ha de comprobar sempre si la instancia es la mateixa per a utiulitzaar els
                              // metodes de la classe fill
            ((B) a).fooB();
        }
    }
}

class A {

    public void foo() {
        System.out.println("A");
    }

    public void runFoo() {
        this.foo();
    }
}

class B extends A {
    @Override // aixo s'ha de posar quan sobreescrius un metode del la classe PARE que extens

    public void foo() {
        System.out.println("B");
    }

    public void fooB() {
        System.out.println("B");
    }

}
