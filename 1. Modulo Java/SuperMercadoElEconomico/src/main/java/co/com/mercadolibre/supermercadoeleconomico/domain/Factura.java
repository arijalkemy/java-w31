package co.com.mercadolibre.supermercadoeleconomico.domain;

import java.util.List;

public class Factura {
        private int id;
        private Cliente cliente;
        private List<Item> items;
        private double total;
        private static int contador = 1; // para generar id de factura de forma automática
    
        public Factura(Cliente cliente, List<Item> items) {
            this.id = contador++;
            this.cliente = cliente;
            this.items = items;
            this.total = calcularTotal();
        }
    
        private double calcularTotal() {
            double suma = 0;
            for (Item item : items) {
                suma += item.getSubtotal();
            }
            return suma;
        }
    
        public int getId() {
            return id;
        }
    
        public Cliente getCliente() {
            return cliente;
        }
    
        public List<Item> getItems() {
            return items;
        }
    
        public double getTotal() {
            return total;
        }
    
        @Override
        public String toString() {
            return "Factura{" +
                    "id=" + id +
                    ", cliente=" + cliente +
                    ", items=" + items +
                    ", total=" + total +
                    '}';
    }
}