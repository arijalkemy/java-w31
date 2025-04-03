package EJINT_SupermercadoElEconomico;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public void agregarItem(Item item) {
        this.items.add(item);
        total+= item.getTotal();
    }

    public double getTotal() {
        return total;
    }
}
