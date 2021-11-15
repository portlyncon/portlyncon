package curs_java.ecercicis.exepcions;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class exemple_exepcions {

    public static void main(String[] args) {
        Utils ut = new Utils();
        System.out.println(ut.foo());
        // System.out.println("main 1");
        // ut.doThat();
        // System.out.println("main 2");
    }

    class Utils {
        public void doThat() {
            System.out.println("doThat 1");
            try {
                doThis();
                System.out.println("after doThis()");
            } catch (IOException e) {
                System.out.println("RuntimeException o IOException");
            } catch (Exception e) {
                System.out.println("Fallo");
            } finally {
                System.out.println("finally");
            }
            System.out.println("doThat 2");
        }

        public void doThis() throws IOException {
            System.out.println("doThis 1");
            // if(true)
            // throw new Exception("Hacaba de fallar algo!!!");

            int[] arr = new int[4];
            arr[5] = 5;

            System.out.println("doThis 2");
        }

        public int foo() {
            try {
                // throw new ArrayIndexOutOfBoundsException();
                System.out.println("try");
                return 5;
            } catch (NumberFormatException ne) {
                return 4;
            } catch (Exception e) {
                System.out.println("catch");
                return 3;
            } finally {
                System.out.println("finally");
                return 1;
            }

        }

        public void foo2() throws IOException, MyException {
            File f = new File("//asdfasdfasdf");
            FileReader fr = null;
            try {
                fr = new FileReader(f);
                fr = new FileReader(f);
                fr = new FileReader(f);
                fr = new FileReader(f);
            } catch (IOException ioe) {

            } finally {
                try {
                    fr.close();
                } catch (IOException ie) {

                }
            }

            // las variables declaradas en el try-with-resource se convierte en final
            try (FileReader fr2 = new FileReader(f); FileReader fr3 = new FileReader(f)) {

            }

            if (true) {
                throw new MyException();
            }

        }

        public void foo3() throws Exception {
            try {
                foo2();
            } catch (MyException me) {
                throw me;
            } catch (IOException me) {
                throw new Exception();
            }
        }
    }
}

class MyException extends Exception {

}
