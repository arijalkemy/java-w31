package bootcamp.integrador_mañana;

public class Reserva {
    private boolean hotel;
    private boolean comida;
    private boolean boletos;
    private boolean transporte;

    public Reserva(boolean hotel, boolean comida, boolean boletos, boolean transporte) {
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public boolean isHotel() {
        return hotel;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public boolean isComida() {
        return comida;
    }

    public void setComida(boolean comida) {
        this.comida = comida;
    }

    public boolean isBoletos() {
        return boletos;
    }

    public void setBoletos(boolean boletos) {
        this.boletos = boletos;
    }

    public boolean isTransporte() {
        return transporte;
    }

    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "hotel=" + hotel +
                ", comida=" + comida +
                ", boletos=" + boletos +
                ", transporte=" + transporte +
                '}';
    }

    public boolean isCompleto() {
       return isHotel() && isComida() && isBoletos() && isTransporte();
    }
}
