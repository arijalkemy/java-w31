package com.mercadolibre.modulojava.ejerciciocircuitos;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Main {
    public static int numerop = 0;
    public static int numeroi = 0;

    public Main() {
    }

    public static void main(String[] args) {
        Circuito chico = new Circuito("2 km por selva y arroyos.", 1);
        Circuito medio = new Circuito("5 km por selva, arroyos y barro.", 2);
        Circuito avanzado = new Circuito("10 km por selva, arroyos, barro y escalada en piedra.", 3);
        Persona juan = new Persona(1009854383, "Juan", "Martinez", 15, "3204873820", "3152368071", "AB+");
        juan.inscribirPersona(chico);
        Persona diego = new Persona(1024234234, "Diego", "Roncancio", 33, "234113243234", "234234234234", "B+");
        diego.inscribirPersona(chico);
        new Persona(1193798373, "Jose", "Rosario", 19, "12323991231902", "12378236187236", "O+");
        diego.inscribirPersona(medio);
        Persona jessica = new Persona(1243242404, "Jessica", "Godoy", 22, "323423423424", "23423534563543", "A+");
        jessica.inscribirPersona(avanzado);
        chico.getInscripciones();
        chico.desinscribirPersona(juan);
        System.out.println("Monto total chico: " + chico.totalMonto());
        System.out.println("Monto total medio: " + medio.totalMonto());
        System.out.println("Monto total avanzado: " + avanzado.totalMonto());
        System.out.println("Monto recaudado de todas las carreras: " + (chico.totalMonto() + medio.totalMonto() + avanzado.totalMonto()));
    }
}
