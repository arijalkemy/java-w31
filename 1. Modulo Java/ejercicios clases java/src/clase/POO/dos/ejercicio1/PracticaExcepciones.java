package clase.POO.dos.ejercicio1;

public class PracticaExcepciones {

    private int a;
    private int b;

    PracticaExcepciones(int a, int b){
        this.a = a;
        this.b = b;
    }

    public  void calcularCociente() {
        try {
            if (a == 0) {
                throw new IllegalArgumentException("Se ha producido un error");
            }
            int cociente = b / a;
            System.out.println(cociente);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

}
