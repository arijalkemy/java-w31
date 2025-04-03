package distribuidora;

public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[3];

        productos[0] = new Perecedero("Leche", 100, 2);
        productos[1] = new NoPerecedero("Arroz", 50, "Alimento");
        productos[2] = new Perecedero("Carne", 200, 1);

        int cantidad = 5;
        for (Producto producto : productos) {
            System.out.println(producto);
            System.out.println("Precio total por " + cantidad + " unidades: " + producto.calcular(cantidad));
            System.out.println("-----------------------------------");
        }
    }
}
