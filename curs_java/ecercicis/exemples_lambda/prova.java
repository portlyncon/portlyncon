package curs_java.ecercicis.exemples_lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class prova {

    static List<Alumno> listaAlumnos = new ArrayList<Alumno>();

    public static void main(String[] args) {

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
        // Recorrer todos los elementos de la colección imprimiendo por pantalla cada
        // uno de ellos

        listaAlumnos.stream()
                .forEach(System.out::println);
    }

}
