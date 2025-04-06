public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new NoPerecedero("Arroz", 100, "Legumbre");
        productos[1] = new NoPerecedero("Harina", 50, "Polvo");
        productos[2] = new NoPerecedero("Fideos", 30, "Pasta");
        productos[3] = new NoPerecedero("Polenta", 20, "Polvo");
        productos[4] = new NoPerecedero("Leche larga vida", 120, "Lacteo");
        productos[5] = new Perecedero("Leche", 100, 2);
        productos[6] = new Perecedero("Carne", 200, 5);
        productos[7] = new Perecedero("Yoghurt", 90, 1);
        productos[8] = new Perecedero("Queso", 150, 1);
        productos[9] = new Perecedero("Pan", 30, 3);


        for (int i = 0; i < productos.length; i++) {
            System.out.println(productos[i].getNombre() + " --> " + productos[i].calcular(5));
        }
    }
}