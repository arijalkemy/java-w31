package supermercado;

public class Factura {
    private Cliente cliente;
    private Item[] items;
    private double total;
    private String fecha;

    public Factura(Cliente cliente, Item[] items, double total, String fecha) {
        this.cliente = cliente;
        this.items = items;
        this.total = total;
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
