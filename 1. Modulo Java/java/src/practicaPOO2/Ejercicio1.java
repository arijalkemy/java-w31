package practicaPOO2;

public class Ejercicio1 {
    private int a = 0;
    private int b = 300;

    public void calcularCociente() {
        try {
            int cociente = b / a;
            System.out.println("El cociente es: " + cociente);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args) {
        Ejercicio1 ejercicio1 = new Ejercicio1();
        try{
            ejercicio1.calcularCociente();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
