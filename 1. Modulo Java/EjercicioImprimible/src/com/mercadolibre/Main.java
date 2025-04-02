package com.mercadolibre;

public class Main {
    public static void main (String []args){
        Persona p = new Persona("Ornella", 22, "Universidad Nacional de La Matanza", "La Tablada", 12930485);
        Curriculum c = new Curriculum(p);
        c.agregarHabilidad("Programación orientada a objetos");
        c.agregarHabilidad("Diseño UX/UI");
        System.out.println(c.imprimir());
        System.out.println("*--------------------*");
        LibrosPDF l = new LibrosPDF(30, "Ricardo Fort", "Los lujos de MAIAME", "Humor");
        System.out.println(l.imprimir());
        System.out.println("*--------------------*");
        Informe i = new Informe("Hola esto es un informe", 4, "Quevedo", "Bizarrap");
        System.out.println(i.imprimir());
    }
}
