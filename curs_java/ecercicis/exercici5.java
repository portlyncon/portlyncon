package curs_java.ecercicis;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class exercici5 {

    public static int media;

    public static void main(String[] args) {

        long lowerMedia, upperMedia;
        int numPeople = 0;
        int[] array = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce number of people");

        try {
            numPeople = sc.nextInt();
            array = new int[numPeople];
            System.out.println("Introduce heigh of people");
            int i = 0;
            while (i < numPeople) {
                array[i] = sc.nextInt();
                media += array[i];
                i++;
            }
        } catch (InputMismatchException e) {
            System.out.println("You must introduce an integer");
        }

        sc.close();

        media = media / numPeople;

        System.out.println("media: " + media);

        lowerMedia = Arrays.stream(array).filter(n -> n < media).count();
        upperMedia = Arrays.stream(array).filter(n -> n < media).count();

        System.out.println("up: " + upperMedia);
        System.out.println("down: " + lowerMedia);

    }
}
