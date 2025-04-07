package practica;
public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[3];
        productos[0] = new NoPerecedero("Alimento", "Arroz", 1.5);
        productos[1] = new Perecedero(2, "Pan", 12.2);
        productos[2] = new Perecedero(7, "Leche", 3.8);

        productos[0].calcular(3);
        System.out.println("El precio reducido es: " + productos[1].calcular(4));
        double precioTotal = 0;
        for (Producto producto : productos) {
            precioTotal += producto.getPrecio() * 5;
        }

        System.out.println("El precio total al vender 5 productos de cada tipo es: $" + precioTotal);
    }
}
