package main;


import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;
import java.util.Scanner;

import modelos.Alumno;
import services.EstrategiaOrdenacion;

public class Main { 
    
    public static void main(String[] args) {
        List<Alumno> lstAlumnos = generateLstAlumnos();
        System.out.println("== Lista original ==");
        lstAlumnos.forEach(System.out::println);
        
        //Obtener posibles algoritmos de ordenación
        // ServiceLoader.load(EstrategiaOrdenacion.class)
        //     .stream()
        //     .map(p -> p.get())
        //     .forEach( s -> System.out.println(s.getClass().getModule().getName()));

        // EstrategiaOrdenacion estrategia = ServiceLoader.load(EstrategiaOrdenacion.class)
        //     .stream() //Stream<Provider<EstrategiaOrdenacion>>
        //     .findFirst() //Optional<Provider<EstrategiaOrdenacion>>
        //     .get() //Provider<EstrategiaOrdenacion>
        //     .get(); //EstrategiaOrdenacion

        ServiceLoader<EstrategiaOrdenacion> loader = ServiceLoader.load(EstrategiaOrdenacion.class);
        List<EstrategiaOrdenacion> estrategias = loader.stream()
                    .map(p -> p.get())
                    .collect(Collectors.toList());

        //Mostrar las opciones al usuario para que escoja
        System.out.println("\n\n");
        if(estrategias.isEmpty()) {
            System.out.println("No tenemos algoritmos de ordenación!!");
            System.exit(0);
        }

        System.out.println("== Algortimos posibles ==");
        for(int i=0;i<estrategias.size();i++) {
            System.out.println("["+(i+1)+"] -> "+estrategias.get(i).getClass().getModule().getName());
        }
        System.out.print("Seleccione una opcion: ");
        
        EstrategiaOrdenacion estrategia = null;
        try(Scanner sc = new Scanner(System.in)) {
            int opt = sc.nextInt()-1;
            if(opt < 0 || opt > estrategias.size()) {
                System.out.println("Opcion incorrecta!!!");
                System.exit(0);
            }else {
                estrategia = estrategias.get(opt);
            }
        }

        EstrategiaOrdenacion.Sentido sentido = EstrategiaOrdenacion.Sentido.ASC;
        System.out.print("Seleccione la dirección de ordenación [ASC|DESC]: ");
        try(Scanner sc = new Scanner(System.in)) {
            String optDireccion = sc.next();
            if(optDireccion.equalsIgnoreCase("DESC")) {
                sentido = EstrategiaOrdenacion.Sentido.DESC;
            }
        }  catch(Exception e){}
             

        //Mostrar la lista ordenada según el algoritmo escogido
        System.out.println("\n\n");
        System.out.println("== Lista ordenada ==");
        lstAlumnos.stream()
            .sorted(estrategia.getAlgoritmo(sentido))
            .forEach(System.out::println);
        
    }

    private static List<Alumno> generateLstAlumnos() {
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

        return listaAlumnos;
    }
}
