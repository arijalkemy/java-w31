
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total;

    public Localizador(Cliente cliente, List<Reserva> reservas, RepositorioCliente repoCliente) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotal(repoCliente);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String stringReservas = "";

        for (Reserva r : reservas) {
            stringReservas += "\n" + r.toString();
        }

        return "Localizador{" +
                "\ncliente=" + cliente.toString() +
                ", \nreservas=" + stringReservas +
                ", \ntotal=" + total +
                '}';
    }

    public Double calcularTotal(RepositorioCliente repoCliente)
    {
        Double total = 0D;
        for (int i = 0; i < reservas.size(); i++) {
            total += reservas.get(i).getCosto();
        }

        Double porcentajeDescuentoGeneral = calcularDescuentosGenerales(repoCliente);
        Double importeDescuentoEspecial = calcularImporteDescuentoEspecial();

        total = total * (1 - (porcentajeDescuentoGeneral / 100));
        total = total - importeDescuentoEspecial;

        return total;
    }

    public Double calcularImporteDescuentoEspecial() {
        Integer cantidadHotel = 0;
        Integer cantidadBoleto = 0;

        Double importe = 0D;

        Double importeDeDescuento = 0D;

        for (Reserva r : this.reservas) {
            if (r.getTipo().equals("Hotel")) {
                cantidadHotel++;
                importe += r.getCosto();
            } else if (r.getTipo().equals("Boleto")) {
                cantidadBoleto++;
                importe += r.getCosto();
            }
        }

        if (cantidadHotel.equals(2) && cantidadBoleto.equals(2)) {
            importeDeDescuento = importe * .05;
        }

        return importeDeDescuento;
    }

    public Double calcularDescuentosGenerales(RepositorioCliente repoCliente) {
        Double descuento = 0D;

        Long cantidadDeLocalizadoresDelCliente = repoCliente.getLocalizadores().stream().filter(l -> l.getCliente().equals(this.cliente)).count();

        if (cantidadDeLocalizadoresDelCliente >= 2) {
            descuento += 5;
        }

        Boolean tieneHotel = Boolean.FALSE;
        Boolean tieneComida = Boolean.FALSE;
        Boolean tieneBoleto = Boolean.FALSE;
        Boolean tieneTransporte = Boolean.FALSE;

        for (int i = 0; i < this.reservas.size(); i++) {
            switch (this.reservas.get(i).getTipo()) {
                case "Hotel":
                    tieneHotel = Boolean.TRUE;
                    break;
                case "Comida":
                    tieneComida = Boolean.TRUE;
                    break;
                case "Boleto":
                    tieneBoleto = Boolean.TRUE;
                    break;
                case "Transporte":
                    tieneTransporte = Boolean.TRUE;
                    break;
            }
        }

        if (tieneHotel && tieneComida && tieneBoleto && tieneTransporte) {
            descuento += 10;
        }

        return descuento;
    }
}
