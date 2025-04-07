package bootcamp.saludable;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("David", 26, "12345678");
        Persona persona3 = new Persona("Jose", 30, "87654321", 70, 1.75);

//      No creamos un constructor con estos datos
//      Persona persona4= new Persona("Ana", 25);

        int imc = persona3.calcularIMC();
        switch (imc) {
            case -1:
                System.out.println("Peso bajo");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            default:
                System.out.println("No se puede calcular el IMC");
                break;
        }
        System.out.println(persona3.esMayorDeEdad());
        System.out.println(persona3.toString());
    }
}