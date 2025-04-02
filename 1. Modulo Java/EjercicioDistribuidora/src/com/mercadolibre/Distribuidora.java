package com.mercadolibre;

public class Distribuidora {
    public static void main (String[] args){
        Producto leche = new Perecedero("Leche", 1000.0, 3);
        Producto pan = new Perecedero("Pan", 2500.0, 2);
        Producto carne = new Perecedero("Carne", 3000.0, 1);

        Producto arroz = new NoPerecedero("Arroz", 750.0, "Granos");
        Producto detergente = new NoPerecedero("Detergente", 1500.0, "Limpieza");


        Producto productos[] = new Producto[5];
        productos[0] = leche;
        productos[1] = pan;
        productos[2] = carne;
        productos[3] = arroz;
        productos[4] = detergente;

        for (Producto producto : productos){
            producto.calcular(5);
        }
    }
}
