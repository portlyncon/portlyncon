/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package curs_java.ecercicis.exemples_lambda;

import java.security.PKCS12Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 * @author angelssanchez
 */
public class LambdaFuctions {

        public static void main(String[] args) {

                List<Alumno> listaAlumnos = new ArrayList<>();

                listaAlumnos.add(new Alumno(1, "1717213183", "Javier Ignacio", "Molina Cano", "Java", 7, 28));
                listaAlumnos.add(new Alumno(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez", "Java", 10, 33));
                listaAlumnos.add(new Alumno(3, "1717328901", "Sixto Naranjoe", "Marín", "Java", 8.6, 15));
                listaAlumnos.add(new Alumno(4, "1717567128", "Gerardo Emilio", "Duque Gutiérrez", "Java", 10, 13));
                listaAlumnos.add(new Alumno(5, "1717902145", "Jhony Alberto", "Sáenz Hurtado", "Java", 9.5, 15));
                listaAlumnos.add(new Alumno(6, "1717678456", "Germán Antonio", "Lotero Upegui", "Java", 8, 34));
                listaAlumnos.add(new Alumno(7, "1102156732", "Oscar Darío", "Murillo González", "Java", 8, 32));
                listaAlumnos.add(new Alumno(8, "1103421907", "Augusto Osorno", "Palacio Martínez", "PHP", 9.5, 17));
                listaAlumnos.add(new Alumno(9, "1717297015", "César Oswaldo", "Alzate Agudelo", "Java", 8, 26));
                listaAlumnos.add(new Alumno(10, "1717912056", "Gloria Amparo", "González Castaño", "PHP", 10, 28));
                listaAlumnos.add(new Alumno(11, "1717912058", "Jorge León", "Ruiz Ruiz", "Python", 8, 22));
                listaAlumnos.add(new Alumno(12, "1717912985", "John Jairo", "Duque García", "Java Script", 9.4, 32));
                listaAlumnos.add(new Alumno(13, "1717913851", "Julio Cesar", "González Castaño", "C Sharp", 10, 22));
                listaAlumnos.add(new Alumno(14, "1717986531", "Gloria Amparo", "Rodas Monsalve", "Ruby", 7, 18));
                listaAlumnos.add(new Alumno(15, "1717975232", "Gabriel Jaime", "Jiménez Gómez", "Java Script", 10, 18));

                // 1. Recorrer todos los elementos de la colección imprimiendo por pantalla cada
                // uno de ellos
                // 2. Imprimir todos los alumnos cuyo nombre comience por la letra ‘L’ o ‘G’
                // 3. Recuperar una nueva colección con alumnos que coinciden con el filtro del
                // enunciado
                // anterior. Imprimir todos los registros de esta nueva colección
                // 4. Obtener los alumnos con notas mayores a 9 para el curso “PHP”
                // 5. Imprimir solo los 2 primeros alumnos de la colección usando limit()
                // 6. Obtener el alumno que tiene la menor edad
                // 7. Obtener el alumno que tiene la mayor edad
                // 8. Mostrar el primer alumno de la lista usando findFirst()
                // 9. Obtener todos los alumnos cuyo nombre de curso termine por el carácter t
                // 10. Obtener todos los alumnos cuyo nombre tenga más de 10 caracteres
                // 11. Obtener todos los alumnos cuyo nombre empece por la letra ‘P’ y tenga un
                // longitud menor o
                // igual a 6
                // 12. Obtener un mapa que agrupe los alumnos los alumnos por curso
                // 13. Obtener un mapa que indique cuantos alumnos hay por cada curso
                // 14. Obtener un mapa que almacene la edad total de los alumnos de cada curso
                listaAlumnos.stream()
                                .filter(x -> x.getNombres().startsWith("L") || x.getNombres().startsWith("G"))
                                .forEach(System.out::println);

                List<Alumno> res = listaAlumnos.stream()
                                .filter(x -> x.getNombres().startsWith("L") || x.getNombres().startsWith("G"))
                                .collect(Collectors.toList());

                listaAlumnos.stream().filter(a -> a.getNombreCurso().equals("PHP") && a.getNota() > 9)
                                .forEach(System.out::println);

                listaAlumnos.stream().limit(2).forEach(System.out::println);

                Alumno menorEdad = listaAlumnos.stream()
                                .min(Comparator.comparing(Alumno::getEdad)).orElseThrow();

                System.out.println("exercici8");
                Optional<Alumno> opt = listaAlumnos.stream().findFirst();
                if (opt.isPresent()) {
                        System.out.println(opt.get());
                }

                Map<String, List<Alumno>> alumnosPorCurso = listaAlumnos.stream()
                                .collect(Collectors.groupingBy(Alumno::getNombreCurso));

                Map<Object, Long> totalAlumno = listaAlumnos.stream()
                                .collect(Collectors.groupingBy(s -> s.getNombreCurso(), Collectors.counting()));

                totalAlumno.forEach((o, aLong) -> System.out.println(aLong));

                Map<String, Integer> sumEDADPorCurso = listaAlumnos.stream()
                                .collect(Collectors.groupingBy(Alumno::getNombreCurso,
                                                Collectors.summingInt(Alumno::getEdad)));

                List<String> lstTexto = Arrays.asList("hola", "mundo", "que", "tal");
                // String str = "hola mundo que tal";

                String str = lstTexto.stream().parallel()
                                .collect(StringBuilder::new, (sb, s) -> sb.append(" ").append(s), StringBuilder::append)
                                .toString();

                Supplier<StringBuilder> supp = StringBuilder::new;
                BiConsumer<StringBuilder, String> bionsumerAcumulador = (sb, s) -> sb.append(" ").append(s);
                BiConsumer<StringBuilder, StringBuilder> bionsumerCombinador = (sb1, sb2) -> sb1.append("***")
                                .append(sb2.toString());
                String strwww = lstTexto.stream().parallel().collect(supp, bionsumerAcumulador, bionsumerCombinador)
                                .toString();
                System.out.println(strwww);

                lstTexto.stream().reduce("", (s1, s2) -> s1 + " " + s2);

        }
}
