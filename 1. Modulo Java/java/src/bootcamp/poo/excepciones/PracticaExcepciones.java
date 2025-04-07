package bootcamp.poo.excepciones;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;
    public void dividirPorCero() {
        try {
            int c = b / a;
        } catch (Exception e) {
            System.out.println("No se puede dividir entre cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
    public void dividirPorCeroExcepcion() {
        try {
            int c = b / a;
        } catch (Exception e) {
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
    }
}
