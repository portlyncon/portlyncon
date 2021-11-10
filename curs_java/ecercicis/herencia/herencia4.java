package curs_java.ecercicis.herencia;

interface I1 {// tot el que te definit sempre es public i els metodes sempre son public
              // abstractes i les constants static final

    String VALOR1 = "Hola";

    void foo();

    // java8
    default void myMethod() {

    }
}

// les interficies tambe poden extendre altres interficies, nomes una
// una classe pot extender una altre clase
// una clase pot implementa una o mes interficies
// una clse pot extendre una ckase e implementar una o mes interficies

interface I2 extends I1 {
}

abstract class B1 {
    public static final String VALOR1 = "Hola";

    public abstract void foo();
}

class MyClass extends B1 implements I1 {// extend i implementa la interficie

    @Override
    public void foo() {
        // TODO Auto-generated method stub

    }

}

public interface herencia4 {

    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.myMethod();
    }

}
