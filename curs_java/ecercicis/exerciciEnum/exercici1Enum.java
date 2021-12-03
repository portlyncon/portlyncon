package curs_java.ecercicis.exerciciEnum;

import java.util.Scanner;

public class exercici1Enum {

    public enum DiaSemana {

        Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo;

    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {

            System.out.println("Elige un dia de la Semana: Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo");

            String opcion = entrada.nextLine();

            try {
                DiaSemana dia = DiaSemana.valueOf(opcion);

                String diaString = obtenerDia(dia);
                System.out.println(diaString);
            } catch (Exception e) {
                System.err.println(e);
            }

        }
        entrada.close();
    }

    public static String obtenerDia(DiaSemana dia) {

        switch (dia) {
            case Lunes:
                return DiaSemana.Lunes.toString();
            case Martes:
                return DiaSemana.Martes.toString();
            case Miercoles:
                return DiaSemana.Miercoles.toString();
            case Jueves:
                return DiaSemana.Jueves.toString();
            case Viernes:
                return DiaSemana.Viernes.toString();
            case Sabado:
                return DiaSemana.Sabado.toString();
            case Domingo:
                return DiaSemana.Domingo.toString();
            default:
                return "";
        }
    }
}