package curs_java.ecercicis.exemples_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.*;

public class exemple_lambda {

    public static void repeat(int n,
            Runnable action) {
        for (int i = 0; i < n; i++)
            action.run();
    }

    static List<String> stringList = new ArrayList<>();
    stringList.stream()
    .forEach(System.out::println);


    public class MainLambda {

        public static void searchArr(String[] strList, String searchStr, StringAnalyzer analyzer) {
            for (String currentStr : strList) {
                
                if (analyzer.analyze(currentStr, searchStr)) {
                    System.out.println("Match: " + currentStr);
                   
                    

                   
                }
            }
        }


        
        

        public static <T> void main(String[] args) {
            String[] strList = { "tomorrow", "toto", "to", "timbukto", "the", "hello", "heat" };
            String searchStr = "to";

            // Creando una clase que implemanta interfaz
            StartsWith sw = new StartsWith();
            StringAnalyzer sw2 = new StartsWith();
            MainLambda.searchArr(strList, searchStr, sw);

            // Otra opción es implementar una Anonymous Inner Class
            MainLambda.searchArr(strList, searchStr, new StringAnalyzer() {
                @Override
                public boolean analyze(String target, String searchStr) {
                    return target.startsWith(searchStr);
                }
            });

            // También podemos asignar nuestra Anonymous Inner Class a una referencia
            StringAnalyzer sw3 = new StringAnalyzer() {
                @Override
                public boolean analyze(String target, String searchStr) {
                    return target.startsWith(searchStr);
                }
            };
            MainLambda.searchArr(strList, searchStr, sw3);

            // Una lambda es una forma de implementar las Anonymous Inner Class
            // Aqui la propia lambda esta infiriendo el typo (interfaz funcional)
            // que quereo implementar y por lo tanto el método que implemetamos
            StringAnalyzer sw4 = (String target, String toSearch) -> {
                return target.startsWith(toSearch);
            };
            MainLambda.searchArr(strList, searchStr, sw4);

            // Lambda Expresion - Forma alternativa para crear la Anonymous Inner Class
            MainLambda.searchArr(strList, searchStr, (String target, String toSearch) -> {
                return target.startsWith(toSearch);
            });

            // La inferecencia no termina en la interfaz funcional y el método que
            // implentar.
            // También los tipos de los argumentos de entrada
            MainLambda.searchArr(strList, searchStr, (target, toSearch) -> {
                return target.startsWith(toSearch);
            });

            // Una lambda automáticamente retorna su ejecución cuando solo tiene un
            // sentencia
            MainLambda.searchArr(strList, searchStr, (target, toSearch) -> target.startsWith(toSearch));

            MainLambda.searchArr(strList, searchStr, (target, toSearch) -> target.contains(toSearch));

            MainLambda.searchArr(strList, searchStr, (target, toSearch) -> target.endsWith(toSearch));

            MainLambda.searchArr(strList, searchStr,
                    (target, toSearch) -> target.toUpperCase().endsWith(toSearch.toLowerCase()));

            List<String> lstTexto = new ArrayList<>();
            lstTexto.add("asdfs");
            lstTexto.add("afffff");
            lstTexto.add("2222");

            for (String s : lstTexto) {
                System.out.println(s);
            }

            Consumer c1 = new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(s);
                }
            };
            lstTexto.forEach(c1);
            lstTexto.forEach(s -> System.out.println(s));
        }
    }

}
