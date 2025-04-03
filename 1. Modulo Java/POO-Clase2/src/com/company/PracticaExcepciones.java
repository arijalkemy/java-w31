package com.company;

public class PracticaExcepciones {
    private static int a = 0, b = 300;

    public static void cociente() {
        try {
            int resultado = b / a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        } finally {
            System.out.println("Programa Finalizado");
        }
    }

    public static void cocienteMod() {
        if (a == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero by Miguel");
        }
        int resultado = b / a;
        System.out.println("El resultado es: " + resultado);
    }

    public static void main(String[] args) {
        cociente(); // Captura la excepción correctamente

        try{
            cocienteMod(); // Aquí la excepción se propaga
        }catch (ArithmeticException e){
            System.out.println("Excepcion capturada: " + e.getMessage());
        }

    }
}

