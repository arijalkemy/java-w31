package Practica7;

public class Reserva {
    private String id;
    private TipoReserva tipo;
    private double valor;

    public Reserva(String id, TipoReserva tipo, double valor) {
        this.id = id;
        this.tipo = tipo;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id='" + id + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
