package Practica4;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void cociente() throws IllegalArgumentException{
        try {
            System.out.println( b / a);
        }
        catch(ArithmeticException e){
            System.out.println("se ha producido un error");
            throw new IllegalArgumentException("no se puede dividir por cero");
        }
        finally {
            System.out.println("programa finalizado");
        }
    }

    public static void main(String[] args) {
        PracticaExcepciones pract = new PracticaExcepciones();
        try{
            pract.cociente();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

}


       // Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje “Programa finalizado”

    //    Modificar el programa anterior para que,
//    al producirse el error, en vez de imprimir por consola el mensaje “Se ha producido un error”,
//    lo lance como una excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir por cero”
