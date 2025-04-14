public class PracticaExcepciones {
    public static void main(String[] args) {

        int a = 0;
        int b = 300;

        System.out.println("Punto 1");

        try {
            double c = b / a;
            System.out.println("El resultado de la división es " + c);
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }

        System.out.println("\nPunto 2");

        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por 0.");
            } else {
                double c = b / a;
                System.out.println("El resultado de la división es " + c);
            }
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error." + e.getMessage());
        } finally {
            System.out.println("Programa finalizado.");
        }
    }
}