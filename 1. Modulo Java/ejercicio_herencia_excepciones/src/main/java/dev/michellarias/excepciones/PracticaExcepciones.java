package dev.michellarias.excepciones;

public class PracticaExcepciones {
    public static void main(String[] args) {

        int a = 0, b = 300;

        try {
            int cociente = b / a;
            System.out.println(cociente);
        }catch(Exception e){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}
