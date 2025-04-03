package P2.Ejercicio1;

/*
 * Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300
 * de tipo int. Calcular el cociente de b/a. Controlar la excepción que se lanza
 * indicando el mensaje “Se ha producido un error”. Al final del programa
 * siempre deberá indicar el mensaje “Programa finalizado”
 * 
 * Modificar el programa anterior para que, al producirse el error, en vez de
 * imprimir por consola el mensaje “Se ha producido un error”, lo lance como una
 * excepción de tipo IllegalArgumentException con el mensaje “No se puede dividir
 * por cero”
 */
public class PracticaExcepciones {
    int a;
    int b;
    public PracticaExcepciones() {
        this.a = 0;
        this.b = 300;
    }

    public int bSobreA() {
        try {
            int cociente = this.b / this.a;
            return cociente;
        } catch (Exception e) {
            //System.out.println("Se ha producido un error: " + e.getMessage());
            //return 0;
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}