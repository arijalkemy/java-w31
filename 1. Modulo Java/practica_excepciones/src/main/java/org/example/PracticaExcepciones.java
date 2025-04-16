package org.example;

public class PracticaExcepciones {
    private Integer a;
    private Integer b;

    public PracticaExcepciones(Integer a, Integer b) {
        this.a = a;
        this.b = b;
    }

    public String cociente(){
        try{
            int c = a/b;
            return "El resultado es: " + c;
        }
        catch(Exception e){
            return "Se ha producido un error";
        }
    }
}
