package com.mercadolibre.modulojava.poopartedos;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PracticaExcepciones {
    public static void main(String[] args) {
            int a=0;
            int b=300;
            /*try{
                int c= b/a;
            }catch(ArithmeticException e){
                System.out.println("se ha producido una excepcion");

            }finally{
                System.out.println("programa finalizado");
            }*/
        try{
            if(a==0){
                throw new IllegalArgumentException("no se puede dividir por cero");
            }
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("programa finalizado");
        }

        }
    }
