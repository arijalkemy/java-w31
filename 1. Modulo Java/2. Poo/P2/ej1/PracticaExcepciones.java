
public class PracticaExcepciones {

    private final int a = 0;
    private final int b = 300;

    public void calcularCociente() {
        try {
            int resultado = b / a;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public void calcularCocienteConExcepcion() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            int resultado = b / a;
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones pe = new PracticaExcepciones();
        pe.calcularCociente();
        pe.calcularCocienteConExcepcion();
    }
}
