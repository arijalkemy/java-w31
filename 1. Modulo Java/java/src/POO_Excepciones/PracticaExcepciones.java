package POO_Excepciones;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try {
            int cociente = b/a;
            System.out.println("El cociente entre "+ b + " y "+a+ " es: ");
        } catch (ArithmeticException e){
            //System.out.println("Se ha producido un error"); (ejercicio 1)
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public static void main(String[] args){
        PracticaExcepciones practica = new PracticaExcepciones();
        practica.calcularCociente();
    }
}
