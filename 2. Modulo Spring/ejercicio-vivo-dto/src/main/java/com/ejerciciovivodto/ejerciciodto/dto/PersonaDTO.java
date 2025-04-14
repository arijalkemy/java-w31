package com.ejerciciovivodto.ejerciciodto.dto;

public class PersonaDTO {
    private Integer id;
    private String nombreCompleto;
    private String nombreDeporte;

    public PersonaDTO() {
    }

    public PersonaDTO(Integer id, String nombreCompleto, String nombreDeporte) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
