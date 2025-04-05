package co.com.mercadolibre.ejerciciouno;

import co.com.mercadolibre.ejerciciouno.domain.Excepcion;

public class Main {
    public static void main(String[] args) {
        Excepcion excp = new Excepcion();
        try {
            excp.calcularCociente();
        }catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por zero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}