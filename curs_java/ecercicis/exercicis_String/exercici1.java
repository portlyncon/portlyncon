package curs_java.ecercicis.exercicis_String;

public class exercici1 {

    public static void main(String[] args) {
        String cadena = "";
        StringBuilder cadena_builder = new StringBuilder();
        char caracter = 'x';
        long inici;
        long fi;

        System.out.println("operacion con String");
        inici = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());

        for (int i = 0; i < 100000; i++) {

            cadena = cadena + caracter;
        }
        fi = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());

        System.out.println(fi - inici);

        System.out.println("operacion con StringBuilder");

        inici = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());

        for (int i = 0; i < 100000; i++) {

            cadena_builder.append(caracter);
        }
        fi = System.currentTimeMillis();
        System.out.println(System.currentTimeMillis());

        System.out.println(fi - inici);

    }

}
