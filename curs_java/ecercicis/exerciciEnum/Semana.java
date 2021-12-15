package curs_java.ecercicis.exerciciEnum;

public class Semana {
    // cal crear metode per retornar un int per cada enum correponent al dia de la
    // setmana i depsres sumar o restar en funcio del que demanin
    private DiaSemana dia;

    public Semana(DiaSemana diasemana) {

        this.dia = diasemana;

    }

    public int suma(int n) {

        int sumadiathis = dia.ordinal() + n;

        this.dia = DiaSemana.values()[sumadiathis];

        return sumadiathis / 7;

    }

    public int resta(int n) {

        int sumadiathis = this.suma(-n);

        this.dia = DiaSemana.values()[sumadiathis];
        return sumadiathis;

    }

}
