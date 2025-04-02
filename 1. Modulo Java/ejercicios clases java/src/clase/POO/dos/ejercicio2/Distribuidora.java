package clase.POO.dos.ejercicio2;

public class Distribuidora {
    private Producto[] productos;
    private

    Distribuidora() {
        // Inicializar el array con algunos productos
        productos = new Producto[] {
                new Producto("Producto A", 10.0),
                new Perecedero("Producto B", 20.0, 1),
                new NoPerecedero("Producto C", 15.0, "DE TOMAR")
        };
    }

    public double calcularPrecioTotal(int cantidad) {
        double precioTotal = 0;

        for (Producto producto : productos) {
            precioTotal += producto.calcular(cantidad);
        }

        return precioTotal;
    }

    public static void main(String[] args) {
        Distribuidora distribuidora = new Distribuidora();
        int cantidadDeProductos = 5;
        double precioTotal = distribuidora.calcularPrecioTotal(cantidadDeProductos);

        System.out.println("El precio total al vender " + cantidadDeProductos + " de cada producto es: " + precioTotal);
    }
}