package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        try{
            PracticaExcepciones excep = new PracticaExcepciones();
            excep.cocienteAb();
        }
        catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }
    }
}
