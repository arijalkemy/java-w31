package dev.michell;

import java.util.HashMap;
import java.util.Map;


public class Categoria {

    private int id;
    private CategoriasEnum nombre;
    private String descripcion;
    private Map<Integer, Inscripcion> inscripciones;

    public Categoria(int id, CategoriasEnum nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.inscripciones = new HashMap<>();
    }

    public Categoria agregarInscripcion(Inscripcion inscripcion) {
        if (!validarInscripcion(inscripcion)) {
            System.exit(0);
        }
        inscripcion.setMonto(calcularMonto(inscripcion));
        inscripciones.put(inscripcion.getNumero(), inscripcion);

//        // Vamos Sumando el total recaudado
//        setMontoTotal(getMontoTotal() + inscripcion.getMonto());

        return this;
    }

    public void eliminarInscripcion(Integer numeroInscripcion) {
        inscripciones.remove(numeroInscripcion);
        System.out.printf("dev.michell.Inscripcion %d eliminada\n", numeroInscripcion);
    }

    public void mostrarInscripciones() {
        for (Map.Entry<Integer, Inscripcion> inscripcion : inscripciones.entrySet()) {
            System.out.printf("dev.michell.Inscripcion: %s\n", inscripcion.getValue());
        }
    }

    public double calcularMontoTotal() {
        int montoTotal = 0;
        for (Map.Entry<Integer, Inscripcion> inscripcion : inscripciones.entrySet()) {
            montoTotal += inscripcion.getValue().getMonto();
        }
        return montoTotal;
    }

    private double calcularMonto(Inscripcion inscripcion) {

        boolean esMayor = false;
        if (inscripcion.getParticipante().getEdad() >= 18){
            esMayor = true;
        }

        if (nombre.equals(CategoriasEnum.CHICO)) {
            if (esMayor){
                return 1500;
            }else {
                return 1300;
            }
        } else if (nombre.equals(CategoriasEnum.MEDIO)) {
            if (esMayor){
                return 2300;
            }else {
                return 2000;
            }
        }else {

            // Avanzado
            return 2800;
        }
    }

    private boolean validarInscripcion(Inscripcion inscripcion) {

        // Finalizamos El programa (Podriamos retornar un mensaje de estado)

        if (inscripciones.containsKey(inscripcion.getNumero())) {
            System.out.println("El inscripcion: " + inscripcion.getNumero() + " ya existe");
        }

        if (nombre.equals(CategoriasEnum.AVANZADO) && inscripcion.getParticipante().getEdad() < 18) {
            System.out.println("No se permiten ingreso de menores a 18");
        }

        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}