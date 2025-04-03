package com.mercadolibre;

public class Main {
    public static void main (String[]args){
        Cliente c = new Cliente ("Ornella", "Alonso", "34563123");
        Cliente c2 = new Cliente ("Alejo", "Melissari", "12312323");
        Cliente c3 = new Cliente ("Noelia", "Pucci", "23456789");
        Supermercado s = new Supermercado();
        s.agregarCliente(c);
        s.agregarCliente(c2);
        s.agregarCliente(c3);
        s.recorrerListaClientes();
        s.elimiarCliente(c2);
        s.solicitarDniDeCliente();

        s.crearFactura(c);
    }
}
