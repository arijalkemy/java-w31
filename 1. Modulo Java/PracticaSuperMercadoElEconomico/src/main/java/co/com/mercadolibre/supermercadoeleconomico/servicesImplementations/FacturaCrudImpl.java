package co.com.mercadolibre.supermercadoeleconomico.servicesImplementations;

import java.util.ArrayList;
import java.util.List;

import co.com.mercadolibre.supermercadoeleconomico.domain.Factura;
import co.com.mercadolibre.supermercadoeleconomico.services.ICrud;

public class FacturaCrudImpl implements ICrud<Factura> {

    private List<Factura> facturas = new ArrayList<>();


    @Override
    public void create(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public Factura read(String id) {
        int intId = Integer.parseInt(id);
        for (Factura factura : facturas) {
            if (factura.getId() == intId) {
                return factura;
            }
        }
        return null;
    }

    @Override
    public List<Factura> readAll() {
        return facturas;
    }

    @Override
    public void update(Factura factura) {
        for (int i = 0; i < facturas.size(); i++) {
            if (facturas.get(i).getId() == factura.getId()) {
                facturas.set(i, factura);
                break;
            }
        }
    }

    @Override
    public void delete(String id) {
        int intId = Integer.parseInt(id);
        facturas.removeIf(factura -> factura.getId() == intId);
    }
    
}
