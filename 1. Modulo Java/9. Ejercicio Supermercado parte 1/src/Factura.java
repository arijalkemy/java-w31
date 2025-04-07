import java.util.List;

class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        calcularTotalCompra();
    }

    private void calcularTotalCompra() {
        totalCompra = items.stream().mapToDouble(Item::calcularCostoTotal).sum();
    }
}
