package supermercadoElEconomico;

import java.util.List;

public class Factura implements Identificable<Integer>{
    private Cliente cliente;
    private List<Item> items;
    private int idFactura;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public float getCostoTotal() {
        float total = 0;
        for (Item item : items) {
            total += item.getCostoUnitario();
        }
        return total;
    }

    @Override
    public Integer getID() {
        return idFactura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------").append(System.lineSeparator());
        sb.append("Factura [cliente=").append(cliente).append("]").append(System.lineSeparator());
        sb.append("ID Factura: ").append(idFactura).append(System.lineSeparator());
        for (Item item : items) {
            sb.append(item.toString()).append(System.lineSeparator());
        }

        sb.append("----------------------").append(System.lineSeparator());
        return sb.toString();
    }
}
