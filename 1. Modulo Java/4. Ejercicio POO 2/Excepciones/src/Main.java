//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        practicaExcepciones practica = new practicaExcepciones();

        try {
            practica.programaConError(0, 10);
        } catch (ArithmeticException e) {
            System.out.println("Se produjo un error aritmetico: " + e.getMessage());
        } finally {
            System.out.println("Recordar no dividir por cero.");
        }
    }
}
