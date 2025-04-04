import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    private List<Cliente> clientes;
    private List<Localizador> localizadores;

    public RepositorioCliente() {
        this.clientes = new ArrayList<>();
        this.localizadores = new ArrayList<>();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }
    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Integer cantidadDeLocalizadoresVendidos() {
        return this.localizadores.size();
    }

    public Integer cantidadDeReservas() {
        Integer cantidad = 0;
        for (Localizador l : this.localizadores) {
            cantidad += l.getReservas().size();
        }

        return cantidad;
    }

    public Map<String, List<Reserva>> reservasPorTipo() {
        Map<String, List<Reserva>> reservasPorTipo = new HashMap<>();
        for (Localizador l : this.localizadores) {
            for (Reserva r : l.getReservas()) {
                List<Reserva> reservasPrevias = reservasPorTipo.containsKey(r.getTipo()) ? reservasPorTipo.get(r.getTipo()) : new ArrayList<>();
                reservasPrevias.add(r);
                reservasPorTipo.put(r.getTipo(), reservasPrevias);
            }
        }

        return reservasPorTipo;
    }

    public Double obtenerTotalVentas() {
        Double total = this.localizadores.stream().mapToDouble(l -> l.getTotal()).sum();

        return total;
    }

    public Double obtenerPromedioVentas() {
        Double total = this.localizadores.stream().mapToDouble(l -> l.getTotal()).sum();

        Double promedio = total / (this.localizadores.size() > 0 ? this.localizadores.size() : 1);

        return promedio;
    }
}
