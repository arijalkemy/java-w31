package exercisePoo1;

public class Main {
    public static void main(String[] args) {
        Persona constPersona = new Persona();
        Persona constructPersona2 = new Persona("Andrea", 23, " 3455");
        Persona contruPersona3 = new Persona("Andrés", 15, "5678", 50.00, 1.50);

        double valueIMC = contruPersona3.IMC(50.00, 150.00);
        String StateIMC = null;
        if (valueIMC == -1) {
            StateIMC = "Bajo peso";
        }
        if (valueIMC == 0) {
            StateIMC = "Peso saludable";
        }
        if (valueIMC == 1) {
            StateIMC = "Sobrepeso";
        }

        System.out.println(" Datos: " + contruPersona3.getDate() + "su IMC es :" +
                valueIMC + " estado salud:  " + StateIMC);

    }
}
