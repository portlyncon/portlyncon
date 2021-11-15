package curs_java.ecercicis.herencia_interfaces2;

import java.util.Date;

public class exec {

    public static void main(String[] args) {

        libro lli = new libro(1, "prova  ", new Date(15 / 11 / 2021));
        revista re = new revista(1, "prova_revista  ", new Date(15 / 11 / 2021), 7);

        System.out.println(lli.getCodigo());
        System.out.println(re.getCodigo());
        System.out.println(re.devolver_parametros());
        lli.prestar();
        System.out.println(lli.getPrestado());

    }
}
