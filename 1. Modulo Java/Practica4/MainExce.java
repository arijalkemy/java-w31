package Practica4;

public class MainExce {

    public static void main(String[] args) {

        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

//Código que arroja excepción

        try{
            int[] numeros = new int[5];
            numeros[5] = 10;
        }catch(Exception e){
            System.out.println("error: " + e.getMessage());
        }
        finally {
            System.out.println(mensajeFinal);
        }



    }
}
