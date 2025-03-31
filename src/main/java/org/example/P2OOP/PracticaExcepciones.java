package org.example.P2OOP;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public PracticaExcepciones() {}

    public int divisionThatThrows() {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
        return b/a;
    }

}
