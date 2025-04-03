package com.mercadolibre;

public class Main {
    public static void main (String[]args){
        Cliente c = new Cliente ("Ornella", "Alonso", "34563123");
        Cliente c2 = new Cliente ("Alejo", "Melissari", "12312323");
        Cliente c3 = new Cliente ("Noelia", "Pucci", "23456789");
        Supermercado s = new Supermercado();
        s.realizarAlta(c);
        s.realizarAlta(c2);
        s.realizarAlta(c3);
        s.recorrerListaClientes();
        s.eliminar(c2);
        s.solicitarDniDeCliente();

        s.crearFactura(c);

        Cliente c4 = new Cliente ("Marianela", "Alonso", "12341345");
        s.realizarAlta(c4);
        s.obtenerClientePorId(1);
        s.modificar(c4);
        s.recorrerListaClientes();
        }
}
