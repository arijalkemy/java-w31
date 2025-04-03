package EjerciciosIntegradores.SupermercadoElEconomico.Bonus;

import java.util.ArrayList;
import java.util.List;

public class GestorFacturas implements CRUD<Factura> {
    private List<Factura> facturas;

    public GestorFacturas() {
        this.facturas = new ArrayList<>();
    }

    @Override
    public void alta(Factura factura) {
        if (!facturas.contains(factura)) {
            facturas.add(factura);
        }
    }

    @Override
    public Factura consulta(Long id) {
        for (Factura factura : facturas) {
            if (factura.getId().equals(id)) {
                return factura;
            }
        }
        return null;
    }

    @Override
    public void modificacion(Factura modificada) {
        for (Factura original : facturas) {
            if (original.getId().equals(modificada.getId())) {
                facturas.remove(original);
                facturas.add(modificada);
                return;
            }
        }
    }

    @Override
    public void baja(Long id) {
        for (Factura factura : facturas) {
            if (factura.getId().equals(id)) {
                facturas.remove(factura);
                return;
            }
        }
    }

    @Override
    public void imprimir() {
        facturas.forEach(factura -> System.out.println("Factura: " + factura.getId() + ", Cliente: " + factura.getCliente().getNombre() + " " + factura.getCliente().getApellido() + ", Total: " + factura.getTotal()));
    }

    @Override
    public List<Factura> getTodos() {
        return facturas;
    }
}
