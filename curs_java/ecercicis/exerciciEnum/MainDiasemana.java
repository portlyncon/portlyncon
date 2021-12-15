package curs_java.ecercicis.exerciciEnum;

import java.util.Scanner;

public class MainDiasemana {

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

    // AIXO es POT ACONSEGUIR AMB EL METODE VALUEOF() DEL ENUM.
    public static String obtenerDia(DiaSemana dia) {

        switch (dia) {
            case LUNES:
                return DiaSemana.LUNES.toString();
            case MARTES:
                return DiaSemana.MARTES.toString();
            case MIERCOLES:
                return DiaSemana.MIERCOLES.toString();
            case JUEVES:
                return DiaSemana.JUEVES.toString();
            case VIERNES:
                return DiaSemana.VIERNES.toString();
            case SABADO:
                return DiaSemana.SABADO.toString();
            case DOMINGO:
                return DiaSemana.DOMINGO.toString();
            default:
                return "";
        }
    }
}