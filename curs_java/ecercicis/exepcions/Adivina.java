package curs_java.ecercicis.exepcions;

import java.util.Random;
import java.util.stream.IntStream;

public class Adivina {

    public static final int LIMITE_MAYOR = 501;
    public static final int LIMITE_MENOR = 1;
    int numero;

    public Adivina() {
        Random random = new Random();
        IntStream intStream = random.ints(1, LIMITE_MENOR, LIMITE_MAYOR);
        numero = intStream.sum();
        // int numero = (int) Math.floor(Math.random() * (LIMITE_MENOR - LIMITE_MAYOR +
        // 1) + LIMITE_MAYOR);
    }

    public int adivina(String num) throws adivinaException {

        int numi = Integer.parseInt(num);

        if (numi != numero) {
            if (numi < numero) {
                return -1;
            } else {
                if (numi > numero) {
                    return 1;

                }

            }
        } else {
            if (numi == numero) {
                return 0;
            }
        }
        return numi;
    }
}
