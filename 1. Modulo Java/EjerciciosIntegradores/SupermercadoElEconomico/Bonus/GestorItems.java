package EjerciciosIntegradores.SupermercadoElEconomico.Bonus;

import java.util.List;
import java.util.ArrayList;

public class GestorItems implements CRUD<Item> {
    private List<Item> items;

    public GestorItems() {
        this.items = new ArrayList<Item>();
    }

    @Override
    public void alta(Item item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }

    @Override
    public Item consulta(Long id) {
        for (Item item : items) {
            if (item.getCodigo().equals(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public void modificacion(Item modificado) {
        for (Item original : items) {
            if (original.getCodigo().equals(modificado.getCodigo())) {
                items.remove(original);
                items.add(modificado);
                return;
            }
        }
    }

    @Override
    public void baja(Long id) {
        for (Item item : items) {
            if (item.getCodigo().equals(id)) {
                items.remove(item);
                return;
            }
        }
    }

    @Override
    public void imprimir() {
        items.forEach(item -> System.out.println("Item: " + item.getCodigo() + ", Nombre: " + item.getNombre() + ", Precio: " + item.getPrecio() + ", Cantidad: " + item.getCantidadComprada()));
    }

    @Override
    public List<Item> getTodos() {
        return items;
    }
    
}
