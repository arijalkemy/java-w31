package Practica3;

public class Main {

    //psvm
    public static void main(String[] args) {

        Persona personaVacia = new Persona();
        Persona personaSinPesoAltura = new Persona("Fernando", 33, "3242333");
        Persona personaCompleta = new Persona("Fernando", 33, "3242333", 90.0, 1.80);

        //Persona personaCompleta = new Persona("Fernando", 33); no es posible porque faltan parametros
        System.out.println();
        System.out.println("###################################");
        System.out.println("##########  BIENVENIDO  ###########");
        System.out.println("###################################");
        System.out.println();
        System.out.println("Calculo de IMC de la persona consultada");
        double imc =  personaCompleta.cacularIMC();
        System.out.println("Resultado: " +   imc);
        System.out.println("INFORMACIÓN IMPORTANTE");
        if(imc == 0){
            System.out.println("Se encuentra en peso saludable");
        }
        if(imc == 1){
            System.out.println("Esta con sobrepeso");
        }
        if(imc == -1){
            System.out.println("Esta por debajo de peso");
        }
        if(imc == -999){
            System.out.println("No se puede calcular porque no se ingresaron los valores necesarios (peso o altura)");
        }

        System.out.println();
        if(personaCompleta.esMayorDeEdad()){
            System.out.println("La persona consultada es mayor de edad");
        }
        else{
            System.out.println("La persona consultada no es mayor de edad");
        }
        System.out.println();
        System.out.println("Datos de la persona consultada");
        System.out.println(personaCompleta.toString());
        System.out.println();
        System.out.println("###################################");
        System.out.println("##########     ADIOS    ###########");
        System.out.println("###################################");


    }

}
