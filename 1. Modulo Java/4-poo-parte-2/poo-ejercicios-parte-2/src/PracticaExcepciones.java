public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    // Ejercicio 1.1
    public void cociente1_1() {
        try {
            double cociente = b/a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
            // e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    // Ejercicio 1.2
    public void cociente1_2() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
            double cociente = b/a;
        } catch (IllegalArgumentException e) {
            //System.out.println("Se ha producido un error");
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
