package clasesagencia;

import java.util.HashMap;
import java.util.List;

public class Localizador {
    private Cliente cliente;
    private Double total;
    private List<Reserva> reservas;
    private Integer numLocalizador;
    private Boolean esPaqueteCompleto;
    private HashMap<String, Integer> tiposReservas;


    public Localizador(Cliente cliente, Double total, List<Reserva> reservas, Integer numLocalizador) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
        this.numLocalizador = numLocalizador;
        this.revisarTiposReservas();
    }

    public void mostrarLocalizador(){
        System.out.println("Localizador numero: " + numLocalizador);
        System.out.println(cliente.toString());
        this.calcularTotal();
        System.out.println("Total: " + total);
        for (Reserva reserva : reservas) {
            System.out.println(reserva.toString());
        }
    }

    public void calcularTotal(){
        for (Reserva reserva : reservas) {
            total += reserva.getValor();
        }
        this.setTotal(total);
    }

    public void setTotal(Double total) {
        this.total = total - (total * cliente.getDescuento());
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void revisarTiposReservas() {
        tiposReservas = new HashMap<>();
        for (Reserva reserva : reservas) {
            String tipoReserva = reserva.getTipoReserva();
            if (tiposReservas.containsKey(tipoReserva)) {
                int conteoActual = tiposReservas.get(tipoReserva);
                tiposReservas.put(tipoReserva, conteoActual + 1);
            } else {
                tiposReservas.put(tipoReserva, 1);
            }
        }
    }

    public Boolean getEsPaqueteCompleto (){
        if (tiposReservas.size() == 4) {
            esPaqueteCompleto = true;
        }else{
            esPaqueteCompleto = false;
        }
        return esPaqueteCompleto;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public HashMap<String, Integer> getTiposReservas() {
        return tiposReservas;
    }

    public Double getTotal() { return total; }
}
