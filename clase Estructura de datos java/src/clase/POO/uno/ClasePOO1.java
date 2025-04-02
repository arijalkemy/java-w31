package clase.POO.uno;

public class ClasePOO1 {
    public static void main(String[] args) {
        Persona diego= new Persona();
        Persona sara= new Persona("Sara",22,"10084834934");
        Persona juan= new Persona("Juan",15,"1439493294",66,1.77);
        int imc=juan.calcularIMC();
        System.out.println(juan);
        System.out.print("IMC:");
        if(imc==-1){
            System.out.println("bajo peso");
        }else if(imc==0){
            System.out.println("peso saludable");
        }else{
            System.out.println("sobrepeso");
        }
        System.out.print("Mayoria de edad: ");
        boolean mayor_edad=juan.esMayorDeEdad();
        if(mayor_edad){
            System.out.println("es mayor de edad");
        }else{
            System.out.println("es menor de edad");
        }
    }
}
