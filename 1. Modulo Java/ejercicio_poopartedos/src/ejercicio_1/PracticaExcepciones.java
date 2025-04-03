package ejercicio_1;

public class PracticaExcepciones {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        extracted(b, a);
    }

    private static void extracted(int b, int a) {
        try {
            int cociente = b / a;
            System.out.println("cociente = " + cociente);
        }catch(Exception e){
//            System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally{
            System.out.println("Programa finalizado");
        }
    }
}