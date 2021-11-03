package curs_java.ecercicis.exercicis_String;

import java.util.Scanner;

public class exercici2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una lista de contraseñas, separadas por comas, para validar su seguridad: ");
        String[] passwords = sc.next().split(",");
        for (String password : passwords) {
            checkSecurity(password);
        }

    }

    private static void checkSecurity(String password) {
        int securityCounter = 0;
        if (password.length() >= 8) {
            securityCounter++;
        }
        if (checkUpper(password)) {
            securityCounter++;
        }
        if (checkLower(password)) {
            securityCounter++;
        }
        if (checkNumber(password)) {
            securityCounter++;
        }
        if (checkNoNumberNoUpperNoLower(password)) {
            securityCounter++;
        }

        if (password.length() < 4 || securityCounter < 3) {
            System.out.println("\"" + password + "\" es una contraseña débil.");
        } else if (securityCounter == 3 || securityCounter == 4) {
            System.out.println("\"" + password + "\" es una contraseña media.");
        } else {
            System.out.println("\"" + password + "\" es una contraseña robusta.");
        }
    }

    private static boolean checkLower(String password) {
        boolean encontrada = false;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }

    private static boolean checkUpper(String password) {
        boolean encontrada = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }

    private static boolean checkNumber(String password) {
        boolean encontrada = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }

    private static boolean checkNoNumberNoUpperNoLower(String password) {
        boolean encontrada = false;
        for (char c : password.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLowerCase(c) && !Character.isUpperCase(c)) {
                encontrada = true;
                break;
            }
        }
        return encontrada;
    }
}