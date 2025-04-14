package practicaPOO2.Ejercicio2Productos;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];

        productos[0] = new Perecedero("Leche", 1500, 1);
        productos[1] = new Perecedero("Yogurt", 1200, 2);
        productos[2] = new NoPerecedero("Arroz", 600, "Grano");
        productos[3] = new NoPerecedero("Aceite", 25, "Líquido");

        double total = 0;
        for( Producto producto : productos) {
            total += producto.calcular(5);
            System.out.println(producto);
        }
        System.out.println("Precio total al vender 5 productos de cada tipo: " + total);
    }
}
