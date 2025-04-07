package ejercicio2;

public class Distribuidora {
    public static void main(String[] args) {
        Producto[] productos = new Producto[4];

        productos[0] = new Perecedero("Leche", 1.50, 1);
        productos[1] = new Perecedero("Queso", 3.00, 3);
        productos[2] = new NoPerecedero("Arroz", 2.00, "Alimento");
        productos[3] = new NoPerecedero("Jabón", 1.00, "Limpieza");

        for (Producto producto : productos) {
            double precioTotal = producto.calcular(5);
            System.out.println("El precio total de 5 unidades de " + producto.getNombre() + " es: " + precioTotal);
        }
    }
}
