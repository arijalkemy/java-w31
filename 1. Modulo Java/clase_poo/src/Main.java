

public class Main {
    
    public static void main(String[] args) {
        String mensajeFinal = "Este es el último mensaje";
        try {
            int[] numeros = new int[5];
            numeros[5] = 10;
        } catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("El indice del array está fuera de límites. " + exception.getMessage());
        } finally {
            System.out.println(mensajeFinal);
        }
    }
}