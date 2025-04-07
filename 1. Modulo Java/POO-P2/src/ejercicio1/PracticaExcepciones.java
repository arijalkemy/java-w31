package ejercicio1;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    //Punto 1
    /*public double calcularCociente(int a, int b) throws ArithmeticException {
        double cociente = 0;
        try {
             cociente = (double) b / a;
        } catch (ArithmeticException ae) {
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }
        return  cociente;
    }*/

    //Punto 2
    public int calcularCociente() throws ArithmeticException {
        int cociente = 0;
        try {
            cociente =  b / a;
        } catch (ArithmeticException ae) {
            throw new IllegalArgumentException("No se puede dividir por cero", ae.getCause());
        } finally {
            System.out.println("Programa finalizado");
        }
        return  cociente;
    }
}
