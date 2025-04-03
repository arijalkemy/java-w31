public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona();
        Persona p2 = new Persona("Frank", 24, "123456789");
        Persona p3 = new Persona("Felipe", 17, "123456789", 1.75, 78.0);

        System.out.println("Es mayor de edad? " + p3.esMayorDeEdad());
        System.out.println(p3);

        int imc = p3.calcularIMC();
        String imcMessage = imc == -1 ? "Bajo peso" : imc == 0 ? "Peso saludable" : "Sobrepeso";
        System.out.println(imcMessage);
    }
}