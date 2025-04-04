package clase.POO.integrador1.agenciaturismo.models;

import java.util.Set;

public class Factura {

    private final int id;
    private final Cliente cliente;
    private final Set<Localizador> localizadores;
    private final double total;
    private final String fechaEmision;

    public Factura(int id, Cliente cliente, Set<Localizador> localizadores, String fechaEmision) {
        this.id = id;
        this.cliente = cliente;
        this.localizadores = localizadores;
        this.fechaEmision = fechaEmision;
        this.total = calcularTotalConDescuentoGlobal();
    }

    /**
     * Calcula el total sin aplicar descuentos adicionales.
     */
    private double calcularTotalSinDescuentos() {
        return localizadores.stream()
                .mapToDouble(Localizador::calcularTotalReservasConDescuento)
                .sum();
    }

    /**
     * Aplica el descuento global si el cliente ha adquirido 2 o más
     * localizadores.
     */
    private double calcularTotalConDescuentoGlobal() {
        double totalSinDescuento = calcularTotalSinDescuentos();
        if (cliente.getCantidadLocalizadores() >= 2) {
            return totalSinDescuento - aplicarDescuento(totalSinDescuento, 5);
        }
        return totalSinDescuento;
    }

    /**
     * Aplica un porcentaje de descuento.
     */
    private double aplicarDescuento(double total, double porcentaje) {
        return total * (porcentaje / 100);
    }

    /**
     * Emite la factura con los datos del cliente y los montos calculados.
     */
    public void emitirFactura() {
        System.out.println("======================================");
        System.out.println("            FACTURA                   ");
        System.out.println("======================================");
        System.out.println("ID Factura: " + id);
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Total sin descuento: $" + calcularTotalSinDescuentos());
        System.out.println("Total final (con descuentos): $" + total);
        System.out.println("Fecha de emisión: " + fechaEmision);
        System.out.println("======================================");
    }

    public double getTotal() {
        return total;
    }
}
