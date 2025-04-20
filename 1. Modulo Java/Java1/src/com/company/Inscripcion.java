package com.company;

public class Inscripcion {
    private int numero;
    private Categoria categoria;
    private Participante participante;
    private double costoInscripcion;

    public Inscripcion(int numero, Categoria categoria, Participante participante) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.costoInscripcion = calcularMonto(categoria,participante);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public double getCostoInscripcion() {
        return costoInscripcion;
    }

    public void setCostoInscripcion(double costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
    }

    public double calcularMonto(Categoria categoria, Participante participante){
        if(categoria.getNombre().equals("Circuito chico")){
            if(participante.getEdad()< 18 ){ // si es menor de 18
                costoInscripcion = 1300;
                return costoInscripcion;
            }else{ // si es mayor de 18
                costoInscripcion = 1500;
                return costoInscripcion;
            }
        }else if(categoria.getNombre().equals("Circuito medio")){
            if(participante.getEdad()<18){
                costoInscripcion = 2000;
                return costoInscripcion;
            }else{
                costoInscripcion = 2300;
                return costoInscripcion;
            }
        }else if(categoria.getNombre().equals("Circuito Avanzado")){
            if(participante.getEdad()<18){
                System.out.println("No se permite inscripciones a menores de 18 años");
            }else{
                costoInscripcion = 2800;
                return costoInscripcion;
            }
        }
        return costoInscripcion;
    }

    @Override
    public String toString() {
        return "Inscripción N°" + numero + ": " +
                participante.getNombre() + " " + participante.getApellido() + '\n' +
                "Edad: " + participante.getEdad() + '\n' +
                "Dni: " + participante.getDni() + '\n' +
                "Celular: " + participante.getCelular() + '\n' +
                "Numero de emergencia: " + participante.getNumeroEmer() + '\n' +
                "Grupo sanguineo: " + participante.getGrupoSang() + '\n' +
                "Categoría: " + categoria.getNombre() + '\n' +
                "Monto de inscripción: $" + costoInscripcion;

    }
}
