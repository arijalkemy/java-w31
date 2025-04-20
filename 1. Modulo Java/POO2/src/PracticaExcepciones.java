public class PracticaExcepciones {
    private int a;
    private int b;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void calcularCociente(){
      try {
            int cociente = b / a;
        } catch (Exception e) {
            System.out.println("Se ha producido un error.");
        } finally {
            System.out.println("Programa finalizado.");
        }

    /*
        try {
            int cociente = b / a;
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero ");}
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("Programa finalizado.");
        }

        */

    }
}
