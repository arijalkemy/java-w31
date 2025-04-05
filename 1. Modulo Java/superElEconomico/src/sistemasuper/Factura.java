package sistemasuper;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private Double totalCompra;


    public Factura(Cliente cliente, List<Item> items, Double totalCompra) {
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = totalCompra;
    }

    public void addItem (Item item){
        items.add(item);
    }

    public Double calcularTotal(){
        for (Item item : items) {
            totalCompra += item.getCantidadComprada()*(item.getCostoUnitario());
        }
        return totalCompra;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("Factura:\n" +
                "Cliente: \n" + cliente.toString() + "\n" +
                "Items:\n");

        for (Item item : items) {
            result.append("\t").append(item.toString()).append("\n");
        }

        result.append("Total de la compra: ").append(calcularTotal()).append("\n");
        return result.toString();
    }

}
