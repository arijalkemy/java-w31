package com.mercadolibre;
import java.util.*;
public class Inscripcion {
    Categoria circuito;
    List<Participante> participantesInscriptosEnCircuitoChico = new LinkedList<>();
    List<Participante> participantesInscriptosEnCircuitoMedio = new LinkedList<>();
    List<Participante> participantesInscriptosEnCircuitoAvanzado = new LinkedList<>();
    Map<Integer, Participante> inscripciones = new HashMap<>();
    double monto;

    public Inscripcion() {

    }

    public List<Participante> getParticipantesInscriptosEnCircuitoChico() {
        return participantesInscriptosEnCircuitoChico;
    }

    public void setParticipantesInscriptosEnCircuitoChico(List<Participante> participantesInscriptosEnCircuitoChico) {
        this.participantesInscriptosEnCircuitoChico = participantesInscriptosEnCircuitoChico;
    }

    public List<Participante> getParticipantesInscriptosEnCircuitoMedio() {
        return participantesInscriptosEnCircuitoMedio;
    }

    public void setParticipantesInscriptosEnCircuitoMedio(List<Participante> participantesInscriptosEnCircuitoMedio) {
        this.participantesInscriptosEnCircuitoMedio = participantesInscriptosEnCircuitoMedio;
    }

    public List<Participante> getParticipantesInscriptosEnCircuitoAvanzado() {
        return participantesInscriptosEnCircuitoAvanzado;
    }

    public void setParticipantesInscriptosEnCircuitoAvanzado(List<Participante> participantesInscriptosEnCircuitoAvanzado) {
        this.participantesInscriptosEnCircuitoAvanzado = participantesInscriptosEnCircuitoAvanzado;
    }

    public boolean inscribirse(Participante p){
        if (inscripciones.containsKey(p.getNumeroDeParticipante())) {
            System.out.println("El participante ya ha sido agregado");
            return false;
        }

        if (this.circuito.getNombre().equals("Circuito avanzado") && p.getEdad() < 18) {
            System.out.println("Error: Los menores de 18 años no pueden inscribirse en el Circuito Avanzado.");
            return false;
        }
        p.setCategoria(this.circuito);
        if(this.circuito.getNombre().equals("Circuito chico")){
            this.participantesInscriptosEnCircuitoChico.add(p);
        } else if (this.circuito.getNombre().equals("Circuito medio")){
            this.participantesInscriptosEnCircuitoMedio.add(p);
        } else {
            this.participantesInscriptosEnCircuitoAvanzado.add(p);
        }


        inscripciones.put(p.getNumeroDeParticipante(), p);
        System.out.println("¡Inscripción exitosa! " + p.getNombre() + p.getApellido() +
                " ha sido inscrito en " + this.circuito.getNombre() + ", su número de participante es: " + p.getNumeroDeParticipante() +
                " y el monto a pagar es: " + this.calcularMonto(p));
        return true;
    }
    public boolean inscribirDeManeraRandom(Participante p) {
        Random random = new Random();
        int numeroAlAzar = random.nextInt(3) + 1;


        if (numeroAlAzar == 1) {
            this.circuito = new Categoria(1,"Circuito chico", "2km por selva y arroyos");
        } else if (numeroAlAzar == 2) {
            this.circuito = new Categoria(2, "Circuito medio", "5km por selva, arroyos y barro");
        } else {
            this.circuito = new Categoria(3, "Circuito avanzado", "10km por selva, arroyo, barro y escalada de piedra");
        }

        return inscribirse(p);
    }

    public void eliminarParticipante(Participante p) {
        if (inscripciones.containsKey(p.getNumeroDeParticipante())) {
            if(this.participantesInscriptosEnCircuitoAvanzado.contains(p)) {
                this.participantesInscriptosEnCircuitoAvanzado.remove(p);
            } else if (this.participantesInscriptosEnCircuitoMedio.contains(p)) {
                this.participantesInscriptosEnCircuitoMedio.remove(p);
            } else {
                this.participantesInscriptosEnCircuitoChico.remove(p);
            }

            inscripciones.remove(p.getNumeroDeParticipante());
            System.out.println("El participante " + p.getNombre() + " ha sido eliminado de la inscripción.");
        } else {
            System.out.println("El participante no estaba inscrito.");
        }

    }
    public double calcularMonto(Participante p) {
        if (p.getCategoria() == null) {
            return 0;
        }

        switch (p.getCategoria().getNombre()) {
            case "Circuito chico":
                return p.getEdad() >= 18 ? 1500 : 1300;
            case "Circuito medio":
                return p.getEdad() >= 18 ? 2300 : 2000;
            case "Circuito avanzado":
                return p.getEdad() >= 18 ? 2800 : 0;
            default:
                return 0;
        }
    }


    public void mostrarInscriptos() {
        System.out.println("/-----------------------------------/");
        System.out.println("Participantes en Circuito Chico: " + this.participantesInscriptosEnCircuitoChico.size());
        for (Participante p : participantesInscriptosEnCircuitoChico) {
            System.out.println(p.getNombre() + " " + p.getApellido() + ", numero de participante: " + p.getNumeroDeParticipante());
        }
        System.out.println("/-----------------------------------/");
        System.out.println("Participantes en Circuito Medio: " + this.participantesInscriptosEnCircuitoMedio.size());
        for (Participante p : participantesInscriptosEnCircuitoMedio) {
            System.out.println(p.getNombre() + " " + p.getApellido()  + ", numero de participante: " + p.getNumeroDeParticipante());
        }
        System.out.println("/-----------------------------------/");
        System.out.println("Participantes en Circuito Avanzado:" + this.participantesInscriptosEnCircuitoAvanzado.size() );
        for (Participante p : participantesInscriptosEnCircuitoAvanzado) {
            System.out.println(p.getNombre() + " " + p.getApellido() + ", numero de participante: " + p.getNumeroDeParticipante());
        }
    }

    public void calcularMontoPorCategoria(){
        double montoChico = 0;
        double montoMedio = 0;
        double montoAvanzado = 0;
        for(Participante p : participantesInscriptosEnCircuitoChico){
            montoChico += calcularMonto(p);
        }
        System.out.println("El monto total en el circuito chico es de: " + montoChico);


        for(Participante p : participantesInscriptosEnCircuitoMedio){
            montoMedio += calcularMonto(p);
        }
        System.out.println("El monto total en el circuito medio es de: " + montoMedio);

        for(Participante p : participantesInscriptosEnCircuitoAvanzado){
            montoAvanzado += calcularMonto(p);
        }
        System.out.println("El monto total en el circuito avanzado es de: " + montoAvanzado);


    }

    public void calcularMontoTotalEnCarrera(){
        double montoTotal = 0;
        for(Participante p : participantesInscriptosEnCircuitoChico){
            montoTotal += calcularMonto(p);
        }

        for(Participante p : participantesInscriptosEnCircuitoMedio){
            montoTotal += calcularMonto(p);
        }
        for(Participante p : participantesInscriptosEnCircuitoAvanzado){
            montoTotal += calcularMonto(p);
        }

        System.out.println("TOTAL RECAUDADO: " + montoTotal);
    }
}
