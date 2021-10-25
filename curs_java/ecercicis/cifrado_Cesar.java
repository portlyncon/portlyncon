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
            System.out.print("Introdueix un texte: ");
            texto = sc.nextLine();
        } while (texto.isEmpty());

        do {
            System.out.print("Introduex un valor de desplaçament: ");
            codigo = sc.nextInt();
        } while (codigo < 1);
        // introduir la opcio del desitjada
        do {
            sc.nextLine();
            System.out.print("(X) xifrar  (D) desxifrar  o (S)sortir: ?");
            opcion = (char) System.in.read();
            if (Character.toUpperCase(opcion) == 'S') {
                System.exit(0);
            }
        } while (Character.toUpperCase(opcion) != 'X' && Character.toUpperCase(opcion) != 'D');
        if (Character.toUpperCase(opcion) == 'X') {
            System.out.println("Texto cifrado: " + cifradoCesar(texto, codigo));
        } else {
            System.out.println("Texto descifrado: " + descifradoCesar(texto, codigo));
        }

    }

    // metode per xifra el text
    public static String cifradoCesar(String texto, int codigo) {
        // utilitzem StringBuilder pq es mes rapid que StringBuffer
        StringBuilder cifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            // encara que no fa falta per saber com a apunts els codis ascii
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
                        cifrado.append((char) (texto.charAt(i) + codigo - 10));
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
        StringBuilder descifrado = new StringBuilder();
        codigo = codigo % 26;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) >= 32 && texto.charAt(i) <= 47 || texto.charAt(i) >= 58 && texto.charAt(i) <= 64
                    || texto.charAt(i) >= 91 && texto.charAt(i) <= 96
                    || texto.charAt(i) >= 123 && texto.charAt(i) <= 126) {
                descifrado.append((char) (texto.charAt(i)));
            } else {
                if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        descifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        descifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        descifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        descifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= '0' && texto.charAt(i) <= '9') {
                    if ((texto.charAt(i) - codigo) < '0') {
                        descifrado.append((char) (texto.charAt(i) - codigo + 10));
                    } else {
                        descifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }
            }
        }
        return descifrado.toString();

    }

}
