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
import java.util.stream.Stream;

/**
 *
 * @author angelssanchez
 */
public class mainAlumnoMulticurso {

        public static void main(String[] args) {

                List<Alumno> listaAlumnos = new ArrayList<>();

                listaAlumnos.add(new AlumnoMulticurso(1, "1212121222", "Javier", "Molina Cano", "Java", 7, 28));

                listaAlumnos.add(new AlumnoMulticurso(2, "1717456218", "Lillian Eugenia", "Gómez Álvarez",
                                Arrays.asList("Java"), 10, 33));
                listaAlumnos
                                .add(new AlumnoMulticurso(3, "1717328901", "Sixto Naranjoe", "Marín",
                                                Arrays.asList("Java"), 8.6, 15));

                listaAlumnos.add(new AlumnoMulticurso(5, "1717902145", "Jhony Alberto", "Sáenz Hurtado",
                                Arrays.asList("Java", "JavaScript"), 9.5, 15));
                listaAlumnos.add(new AlumnoMulticurso(6, "1717678456", "Germán Antonio", "Lotero Upegui",
                                Arrays.asList("Java"), 8, 34));
                listaAlumnos.add(new AlumnoMulticurso(7, "1102156732", "Oscar Darío", "Murillo González",
                                Arrays.asList("Java", "Angular"), 8, 32));
                listaAlumnos.add(new AlumnoMulticurso(8, "1103421907", "Augusto Osorno", "Palacio Martínez",
                                Arrays.asList("PHP", "MySQL"), 9.5, 17));
                listaAlumnos.add(new AlumnoMulticurso(9, "1717297015", "César Oswaldo", "Alzate Agudelo",
                                Arrays.asList("Java", "Angular"), 8, 26));
                listaAlumnos.add(new AlumnoMulticurso(10, "1717912056", "Gloria Amparo", "González Castaño",
                                Arrays.asList("PHP", "MySQL"), 10, 28));
                listaAlumnos.add(new AlumnoMulticurso(11, "1717912058", "Jorge León", "Ruiz Ruiz",
                                Arrays.asList("Python",
                                                "Ruby"),
                                8, 22));
                listaAlumnos.add(new AlumnoMulticurso(12, "1717912985", "John Jairo", "Duque García",
                                Arrays.asList("PHP",
                                                "MySQL"),
                                9.4, 32));
                listaAlumnos.add(new AlumnoMulticurso(13, "1717913851", "Julio Cesar", "González Castaño",
                                Arrays.asList("Python", "C Sharp"), 10, 22));
                listaAlumnos.add(new AlumnoMulticurso(14, "1717986531", "Gloria Amparo", "Rodas Monsalve",
                                Arrays.asList("Python", "Ruby"), 7, 18));
                listaAlumnos.add(new AlumnoMulticurso(15, "1717975232", "Gabriel Jaime", "Jiménez Gómez",
                                Arrays.asList("PHP", "MySQL"), 10, 18));

                listaAlumnos.stream().forEach(System.out::println);

                // Obtén una lista con los alumnos que solo están matriculados en el curso de
                // Java y muéstrala en pantalla

                listaAlumnos.stream().filter(a -> a.getNombreCurso().contentEquals("Java"))
                                .forEach(System.out::println);

                // Obtén una lista con los alumnos que están matriculados al menos en el curso
                // de PHP
                listaAlumnos.stream().filter(a -> a.getNombreCurso().contains("PHP"))
                                .forEach(System.out::println);

                // FALTEN ELS PREDICATES
                // listaAlumnos.stream().filter(conPHP.or(conJava)).forEach(System.out::println);

                //
                // List<AlumnoMulticurso> buscarAlumnos(final List<AlumnoMulticurso>
                // listaAlumnos,
                // final Predicate<AlumnoMulticurso> filtros, Consumer<AlumnoMulticurso>
                // consumer) {
                ////
                //// return listaAlumnos.stream().filter(filtros)
                ////
                //// .peek(consumer != null ? consumer : t -> {} ).collect(Collectors.toList());
                //// }
                //
                // Stream<AlumnoMulticurso>stream =listaAlumnos.stream().filter(filtros);
                //
                // if(consumer!=null){
                // stream = stream.peek(consumer)

                // Usa la función findFirst para localizar un alumno que esté matriculado en el
                // curso de Java y
                // muéstralo por pantalla

                AlumnoMulticurso alumnoMulticurso = (AlumnoMulticurso) listaAlumnos.stream()
                                .filter(s -> ((AlumnoMulticurso) s).getNombreCurso().contains("Java"))
                                .findFirst().orElse(null);
                System.out.println(alumnoMulticurso);

                // Usa la función findAny para localizar un alumno que esté matriculado en el
                // curso de Java y
                // muéstralo por pantalla

                System.out.println(listaAlumnos.stream().findAny().orElse(null));

                // 11. Tomando como punto de partida el código de la solución 9 y 10, enciérralo
                // en un bucle que
                // ejecute la operación 10 veces y que muestre el tiempo consumido en cada
                // iteración.
                // 12. Repite el ejercicio 11 pero usando procesado en paralelo. Compara los
                // resultados con el
                // ejercicio anterior.

                // Haciendo uso avanzado de la función collect generar un único pipeline de
                // Stream Collection
                // capaz de recorrer la colección completa de alumnos y retornar una lista con 2
                // valores enteros, el
                // primero será el contador de alumnos con nota 10 y el segundo el contador de
                // los demás alumnos
                //
                listaAlumnos.forEach(System.out::println);

                /*
                 * System.out.println("****");
                 * //4. Obt n una lista con los alumnos que solo est n matriculados en el curso
                 * de Java y mu strala en pantalla
                 * List<String> filtro = Arrays.asList("Java");
                 * listaAlumnos.stream().filter(a->a.getNombreCursos().equals(filtro)).forEach(e
                 * ->System.out.println(e));
                 * 
                 * 
                 * 
                 * Consumer<AlumnoMulticurso> imprimirAlumno = System.out::println;
                 * Predicate<AlumnoMulticurso> conSoloUnCurso = x -> x.getNombreCursos().size()
                 * == 1;
                 * Predicate<AlumnoMulticurso> conJava = x ->
                 * x.getNombreCursos().contains("Java");
                 * Predicate<AlumnoMulticurso> conPHP = x ->
                 * x.getNombreCursos().contains("PHP");
                 * 
                 * System.out.println("4 - Alumnos matriculados solo en Java");
                 * listaAlumnos.stream().filter(conSoloUnCurso.and(conJava)).forEach(
                 * imprimirAlumno);
                 * 
                 * //5. Obt n una lista con los alumnos que est n matriculados al menos en el
                 * curso de PHP
                 * //"php"::equalsIgnoreCase
                 * listaAlumnos.stream()
                 * .filter(x -> x.getNombreCursos().stream().anyMatch(nombre ->
                 * "php".equalsIgnoreCase(nombre)))
                 * .forEach(System.out::println);
                 * 
                 * listaAlumnos.stream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("PHP"))
                 * .forEach(System.out::println);
                 * 
                 * 
                 * //6. Obt n una lista con los alumnos que est n matriculados en el curso de
                 * PHP pero no el de Java
                 * listaAlumnos.stream().filter(conPHP.and(conJava.negate())).forEach(
                 * imprimirAlumno);
                 * 
                 * listaAlumnos.stream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("PHP") &&
                 * !((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .forEach(System.out::println);
                 * 
                 * 
                 * //7. Obt n una lista con los alumnos que est n matriculados en el curso de
                 * PHP o en el de Java
                 * listaAlumnos.stream().filter(conPHP.or(conJava)).forEach(imprimirAlumno);
                 * 
                 * List<AlumnoMulticurso> listaRes = buscarAlumnos(listaAlumnos,
                 * conPHP.or(conJava), imprimirAlumno);
                 * 
                 * //9. Usa la funci n findFirst para localizar un alumno que est matriculado en
                 * el curso de Java y mu stralo por pantalla
                 * Optional<AlumnoMulticurso> opt = listaAlumnos.stream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .findFirst();
                 * AlumnoMulticurso alumnoMulticurso = opt.orElseGet(AlumnoMulticurso::new);
                 * System.out.println(alumnoMulticurso);
                 * 
                 * System.out.println(listaAlumnos.stream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .findAny().orElse(null));
                 * 
                 * 
                 * long start = System.currentTimeMillis();
                 * for(int i = 0;i<10;i++) {
                 * Optional<AlumnoMulticurso> opt2 = listaAlumnos.stream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .findFirst();
                 * alumnoMulticurso = opt2.orElseGet(AlumnoMulticurso::new);
                 * System.out.println(alumnoMulticurso);
                 * }
                 * System.out.println("Tiempo total (findFirst): "+(System.currentTimeMillis()-
                 * start)+"ms");
                 * 
                 * start = System.currentTimeMillis();
                 * for(int i = 0;i<10;i++) {
                 * System.out.println(listaAlumnos.stream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .findAny().orElse(null));
                 * }
                 * System.out.println("Tiempo total (findAny): "+(System.currentTimeMillis()-
                 * start)+"ms");
                 * 
                 * 
                 * start = System.currentTimeMillis();
                 * for(int i = 0;i<10;i++) {
                 * Optional<AlumnoMulticurso> opt2 = listaAlumnos.stream().parallel()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .findFirst();
                 * alumnoMulticurso = opt2.orElseGet(AlumnoMulticurso::new);
                 * System.out.println(alumnoMulticurso);
                 * }
                 * System.out.println("Tiempo total (findFirst, paralelo): "+(System.
                 * currentTimeMillis()-start)+"ms");
                 * 
                 * start = System.currentTimeMillis();
                 * for(int i = 0;i<10;i++) {
                 * System.out.println(listaAlumnos.parallelStream()
                 * .filter(s -> ((AlumnoMulticurso) s).getNombreCursos().contains("Java"))
                 * .findAny().orElse(null));
                 * }
                 * System.out.println("Tiempo total (findAny, paralelo): "+(System.
                 * currentTimeMillis()-start)+"ms");
                 * 
                 * 
                 * 
                 * 
                 * 
                 * }
                 * 
                 * 
                 * static List<AlumnoMulticurso> buscarAlumnos(final List<AlumnoMulticurso>
                 * listaAlumnos,
                 * final Predicate<AlumnoMulticurso> filtros, Consumer<AlumnoMulticurso>
                 * consumer) {
                 * 
                 * Stream<AlumnoMulticurso> stream = listaAlumnos.stream().filter(filtros);
                 * if(consumer!=null) {
                 * stream = stream.peek(consumer);
                 * }
                 * 
                 * return stream
                 * .collect(Collectors.toList());
                 * }
                 * }
                 */

                /*
                 * 13. Haciendo uso avanzado de la función collect generar un único pipeline de
                 * Stream Collection
                 * capaz de recorrer la colección completa de alumnos y retornar una lista con 2
                 * valores enteros, el
                 * primero será el contador de alumnos con nota 10 y el segundo el contador de
                 * los demás alumnos.
                 */

                /*
                 * 14. En la linea del ejercicio 13, queremos obtener la cantidad de alumnos en
                 * cada tramo de nota
                 * siguiendo los criterios de: SUSPENSO nota <5, APROBADO >=5 y <7, NOTABLE >=7
                 * y <9,
                 * SOBRESALIENTE >=9. NOTA: No es necesario que si no hay ningún alumno en un
                 * rango
                 * aparezca el rango con valor 0.
                 */

                Map<String, Long> res = listaAlumnos.stream()
                                .map(AlumnoMulticurso::getNota)
                                .map(nota -> {
                                        if (nota < 5) {
                                                return "SUSPENSO";
                                        } else if (nota < 7) {
                                                return "APROBADO";
                                        } else if (nota < 9) {
                                                return "NOTABLE";
                                        } else {
                                                return "SOBRESALIENTE";
                                        }
                                })
                                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));

                System.out.println("");
                res.forEach((k, v) -> System.out.println(k + " -> " + v));

        }
}
