package curs_java.ecercicis;

import java.io.IOException;
import java.util.Scanner;

public class cifrado_Cesar {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String texto;
        int codigo;
        char opcion;

        do {
            System.out.print("Introduce un texto: ");
            texto = sc.nextLine();
        } while (texto.isEmpty());

        do {
            System.out.print("Introduce el valor de desplazamineto: ");
            codigo = sc.nextInt();
        } while (codigo < 1);
        // introduir la opcio del desitjada
        do {
            sc.nextLine();
            System.out.print("(C) cifrar o (D) descifrar? (E)salir: ");
            opcion = (char) System.in.read();
            if (Character.toUpperCase(opcion) == 'E') {
                System.exit(0);
            }
        } while (Character.toUpperCase(opcion) != 'C' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'C') {
            System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));
        } else {
            System.out.println("Texto descifrado: " + descifradoCesar(texto, codigo));
        }

    }

    // metode per xifra el text
    public static String cifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {

            if (texto.charAt(i) >= 32 && texto.charAt(i) <= 47 || texto.charAt(i) >= 58 && texto.charAt(i) <= 64
                    || texto.charAt(i) >= 91 && texto.charAt(i) <= 96
                    || texto.charAt(i) >= 123 && texto.charAt(i) <= 126) {
                cifrado.append((char) (texto.charAt(i)));
            } else {

                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) + codigo) > 'z') {
                        cifrado.append((char) (texto.charAt(i) + codigo - 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) + codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) + codigo) > 'Z') {
                        cifrado.append((char) (texto.charAt(i) + codigo - 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) + codigo));

                    }
                } else if (texto.charAt(i) >= '0' && texto.charAt(i) <= '9') {
                    if ((texto.charAt(i) + codigo) > '9') {
                        cifrado.append((char) (texto.charAt(i) + codigo - 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) + codigo));

                    }
                }
            }

        }
        return cifrado.toString();

    }

    // metode per desxifrar el text
    public static String descifradoCesar(String texto, int codigo) {
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 32 && texto.charAt(i) <= 47 || texto.charAt(i) >= 58 && texto.charAt(i) <= 64
                    || texto.charAt(i) >= 91 && texto.charAt(i) <= 96
                    || texto.charAt(i) >= 123 && texto.charAt(i) <= 126) {
                cifrado.append((char) (texto.charAt(i)));
            } else {
                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= '0' && texto.charAt(i) <= '9') {
                    if ((texto.charAt(i) - codigo) < '0') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }
            }
        }
        return cifrado.toString();

    }

}
