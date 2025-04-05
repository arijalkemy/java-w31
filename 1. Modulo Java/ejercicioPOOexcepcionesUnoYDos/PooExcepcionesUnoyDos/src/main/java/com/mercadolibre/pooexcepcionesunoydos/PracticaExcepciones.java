package main.java;

public class PracticaExcepciones {

    private int a =0;
    private  int b=300;

    public void CalcularElCociente(){
        try{
            if(a==0){
                throw new IllegalArgumentException("no se divide por cero");
            }
            int cociente = b/a;
            System.out.println("El cocinete es"+ cociente);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finalizo");
        }
    }
    public static void main(String []args){
        PracticaExcepciones prueba = new PracticaExcepciones();
        prueba.CalcularElCociente();
    }
}
