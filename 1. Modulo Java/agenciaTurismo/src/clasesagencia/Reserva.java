package clasesagencia;

public class Reserva {
    private String tipoReserva;
    private Integer valor;

    public Reserva(String tipoReserva, Integer valor) {
        this.tipoReserva = tipoReserva;
        this.valor = valor;
    }

    public String getTipoReserva() {
        return tipoReserva;
    }

    @Override
    public String toString(){
        return "Tipo de reserva: " + tipoReserva;
    }

    public Integer getValor() { return valor; }
}
