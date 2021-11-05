package curs_java.ecercicis.exercicis_arrayList;

import java.util.ArrayList;
import java.util.Random;

public class exercici3 {
    public static void main(String[] args) {
        int[][] matriz = new int[4][5];
        int[] sumCols = new int[6];
        Random rand = new Random();
        for (int i = 0; i < 4; i++) {
            int sumFila = 0;
            for (int j = 0; j < 5; j++) {
                Integer num = rand.nextInt(10);
                // Generamos el valor para la celda
                matriz[i][j] = num;
                // acumulamos el sumatorio de la fila
                sumFila += num;
                // acumulamos el sumatorio de la columna en el array auxiliar
                sumCols[j] += num;

                // pintamos el valor de esta celda
                System.out.printf("%02d ", num);
            }
            // Acumulamos el valor de la columna del sumatorio de la fila
            sumCols[5] += sumFila;

            // pintamos el sumatorio de la fila
            System.out.printf("=> %03d \n", sumFila);
        }

        // pintamos el acumulado de las columnas excluyendo el acumulado de los
        // acumulados
        for (int i = 0; i < sumCols.length - 1; i++) {
            System.out.printf("02d ", sumCols[i]);
        }
        // pintamos el acumulado de los acumulados
        System.out.printf("=> %03d \n", sumCols[5]);

    }
}
