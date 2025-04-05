package main.java;

public class ImplementacionPersona {
    public static void main(String[] args) {
        // Crear una instancia de Persona ejercicio 4
        Persona persona0 = new Persona();
        Persona persona1 = new Persona("Juan", 30, "12345678", 70.5f, 1.75f);
        Persona persona2 = new Persona("Maria", 25, "87654321");

        double IMC =persona1.calcularIMC();
        if(IMC ==-1){
            System.out.println("Bajo peso");
        }else if (IMC ==0){
            System.out.println("Peso normal");
        }else{
            System.out.println("Sobrepeso");
        }

        if(persona1.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");

        }


        // Mostrar información de las personas
        System.out.println("Persona 1: " + persona1.nombre + ", Edad: " + persona1.edad + ", DNI: " + persona1.dni + ", Peso: " + persona1.peso + ", Altura: " + persona1.altura);
        System.out.println("Persona 2: " + persona2.nombre + ", Edad: " + persona2.edad + ", DNI: " + persona2.dni);
    }
}
