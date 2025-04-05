package exception;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;
    
    public void calcularCociente(){
        String mensajeError = "Se ha producido un error";
        String mensajeFinal = "Programa finalizado";

        try {
            if (a == 0) throw new IllegalArgumentException("No se puede dividir por cero");
            int resultado = b / a;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }finally {
            System.out.println(mensajeFinal);
        }



    }
}
