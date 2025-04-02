package com.mercadolibre.bootcamp;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {

        /** Paso 1
        try{
            int result = b / a;
        }catch(ArithmeticException e){
            System.out.println("Se ha producido un error");
        }finally{
            System.out.println("Programa finalizado");
        } */

        try{
            int result = b / a;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }

    }

    
}
