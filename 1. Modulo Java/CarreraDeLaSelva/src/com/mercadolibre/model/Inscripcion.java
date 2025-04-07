package com.mercadolibre.model;

public class Inscripcion {
    private Integer id;
    private Categoria categoria;
    private Participante participante;
    private Double montoAbonar;

    public Inscripcion(Integer id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
    }


    public void calcularMontoAbonar() {
        boolean menorDeEdad = participante.getEdad() <= 18;

        if (categoria.getTipo() == TipoCategoria.CHICO) {
            montoAbonar = menorDeEdad? 1300.0 : 1500.0;
            return;
        }
        if (categoria.getTipo() == TipoCategoria.MEDIO ) {
            montoAbonar = menorDeEdad? 2000.0 : 2300.0;
            return;
        }
        if (categoria.getTipo() == TipoCategoria.AVANZADO && !menorDeEdad) {
            montoAbonar = 2800.0;
            return;
        }
        montoAbonar = 0.0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getMontoAbonar() {
        return montoAbonar;
    }

    public void setMontoAbonar(Double montoAbonar) {
        this.montoAbonar = montoAbonar;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", montoAbonar=" + montoAbonar +
                '}';
    }
}
