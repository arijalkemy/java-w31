package com.bootcamp.vehiculoshql.dto;

public class VehiculoSiniestroDTO {
    private String matricula;
    private String marca;
    private String modelo;
    private Double perdidaTotal;

    public VehiculoSiniestroDTO(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.perdidaTotal = null;
    }

    public VehiculoSiniestroDTO(String matricula, String marca, String modelo, Double perdidaTotal) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.perdidaTotal = perdidaTotal;
    }

    // Getters y Setters
    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public Double getPerdidaTotal() { return perdidaTotal; }
    public void setPerdidaTotal(Double perdidaTotal) { this.perdidaTotal = perdidaTotal; }
}