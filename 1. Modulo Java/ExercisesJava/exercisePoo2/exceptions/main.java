package exercisePoo2.exceptions;

public class main {
    public static void main(String[] args) {
       
        try {
            PracticaExcepciones excepciones=new PracticaExcepciones();
            excepciones.cociente();
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
       
        
        
    }
}
