package com.mercadolibre.model;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera();
        carrera.setNombre("Carrera Rafela 2025");

        //Instanciamos las 3 categorias
        Categoria catChica = new Categoria(1,"Circuito chico",
                "2 km por selva y arroyos", TipoCategoria.CHICO);

        Categoria catMedia = new Categoria(2,"Circuito medio",
                "5 km por selva, arroyos y barro.", TipoCategoria.MEDIO);

        Categoria catAvanzada= new Categoria(3,"Circuito avanzado",
                "10 km por selva, arroyos, barro y escalada en piedra.", TipoCategoria.AVANZADO);

        //Instanciamos un participante
        Participante participante1 = new Participante("12345678", "Lautaro", "Hevia",
                21,"3492090909", "3492090909", "AB+");

        //Instanciamos la inscripcion y calculamos el monto
        Inscripcion inscripcion1 = new Inscripcion(1,catChica, participante1);
        inscripcion1.calcularMontoAbonar();


        System.out.println("Monto Abonar del participante " + participante1.getNombre() + " " + participante1.getApellido()+
                " es "+ inscripcion1.getMontoAbonar());

        //Instanciamos los participantes faltantes
        Participante participante2 = new Participante("12345678", "Jose", "Perez",
                30,"3492090909", "3492090909", "B+");

        Participante participante3 = new Participante("12345678", "Jhon", "Doe",
                10,"3492090909", "3492090909", "A+");

        //Instanciamos las inscripciones faltantes
        Inscripcion inscripcion2 = new Inscripcion(2,catMedia, participante2);
        inscripcion2.calcularMontoAbonar();
        Inscripcion inscripcion3 = new Inscripcion(3,catAvanzada, participante3);
        inscripcion3.calcularMontoAbonar();


        carrera.addInscripcion(inscripcion1);
        carrera.addInscripcion(inscripcion2);
        carrera.addInscripcion(inscripcion3);

        carrera.mostrarInscriptosPorCategoria(TipoCategoria.CHICO);
        carrera.mostrarInscriptosPorCategoria(TipoCategoria.MEDIO);
        carrera.mostrarInscriptosPorCategoria(TipoCategoria.AVANZADO);

        System.out.println("------------------------");
        //Monto Total antes de desinscribir al participante3
        carrera.calcularMontoTotal();
        System.out.println("Monto total de la carrera carrera: " + carrera.getMontoTotal());

        //Desinscribir a un participante
        carrera.desinscribirParticipante(inscripcion2);


        carrera.calcularMontoTotal();
        System.out.println("Monto total de la carrera: " + carrera.getMontoTotal());

        System.out.println("Monto total de la categoria chica: " + carrera.montoTotalPorCategoria(TipoCategoria.CHICO));
        System.out.println("Monto total de la categoria media: " + carrera.montoTotalPorCategoria(TipoCategoria.MEDIO));
        System.out.println("Monto total de la categoria avanzada: " + carrera.montoTotalPorCategoria(TipoCategoria.AVANZADO));


    }
}
