public class Main {

    public static void main(String[] args) {
        
        Persona user =  new Persona();
        Persona intern = new Persona("Andrés", 22, "001");
        Persona student = new Persona("Mateo", 22, "002", 76.8, 1.74);
        System.out.println("Índice de masa corporal (IMC): " + student.calculateIMC());
        System.out.println("La persona es mayor de edad: " + student.isLegaAge());
        System.out.println("Información Persona: " + student);

    }
    
}
