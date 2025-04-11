package com.example;

public class Inscripcion {
    private static int contador = 1;

    private int idInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double montoInscripcion;

     // Constructor de la clase Inscripcion
    public Inscripcion(Categoria categoria, Participante participante) { // 
        this.idInscripcion = contador++;
        this.categoria = categoria;
        this.participante = participante;
        this.setMontoInscripcion(montoInscripcion);
    }

    public void setMontoInscripcion(double montoInscripcion) {
        int edad =participante.getEdad();

        switch(categoria.getIdCategoria()){
            case 101:
                if(edad<18){
                    this.montoInscripcion = 1300;
                }
                else{
                    this.montoInscripcion= 1500;
                }
                break;
            case 202:
                if(edad<18){
                    this.montoInscripcion = 2000;
                }
                else{
                    this.montoInscripcion = 2300;
                }
                break;
            case 303:
                if(edad<18){
                    throw new IllegalArgumentException("No se permite la inscripcion a menores de 18 años en esta categoria");
                }
                else{
                    this.montoInscripcion = 2800;
                }
                break;
            default:
                throw new IllegalArgumentException("Categoria no valida");
        }
        
    }


    public double getMontoInscripcion() {
        return montoInscripcion;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }
    

}

