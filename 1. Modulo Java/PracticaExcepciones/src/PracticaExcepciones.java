public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int resultado = b / a;
            System.out.println("El resultado es: " + resultado);
        } catch (ArithmeticException e) {
           System.out.println("Se ha producido un error: " + e.getMessage());
            throw new IllegalArgumentException("No se puede dividir por cero", e);
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
