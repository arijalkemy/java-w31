package EJINT_SupermercadoElEconomico;

import java.util.ArrayList;
import java.util.List;

class FacturaCRUD implements CRUD<Factura> {
    private List<Factura> facturas;

    public FacturaCRUD() {
        this.facturas = new ArrayList<>();
    }


    @Override
    public void crear(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public Factura leer(String dni) {
        for (Factura factura : facturas) {
            if(factura.getCliente().getDni().equals(dni)){
                return factura;
            }
        }
        return null;
    }

    @Override
    public void actualizar(Factura factura) {
    }

    @Override
    public void eliminar(String dni) {
        facturas.removeIf(f -> f.getCliente().getDni().equals(dni));
    }

    public List<Factura> getFacturas() {
        return facturas;
    }
}
