package POO_Distribuidora;

public class Distribuidora {
    public static void main(String[] args) {
        // crear un array de productos
        Producto[] productos = new Producto[4];

        // inicializar el array con 2 productos perecederos y 2 no perecederos
        productos[0] = new Perecedero("Leche", 1.50, 3);
        productos[1] = new Perecedero("Yogurt", 1.00, 2);
        productos[2] = new NoPerecedero("Arroz", 2.00, "Grano");
        productos[3] = new NoPerecedero("Conserva de tomate", 1.75, "Enlatado");

        // almacenar el precio total
        double precioTotal = 0;

        // calcular el precio total vendiendo 5 productos de cada tipo
        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        // imprimir el precio total
        System.out.printf("El precio total al vender 5 productos de cada tipo es: %.2f\n", precioTotal);
    }
}
