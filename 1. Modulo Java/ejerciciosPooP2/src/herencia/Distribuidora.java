package herencia;

public class Distribuidora {
    public static void main(String[] args) {
        Perecedero prodPerecedero = new Perecedero("Carne", 150, 20);
        NoPerecedero prodNoPerecedero = new NoPerecedero("Fideos", 50, "Pasta");

        Producto[] productos = {prodPerecedero, prodNoPerecedero};

        for (Producto producto : productos) {
            System.out.println("El total de 5 productos de nombre: " + producto.getNombre() +
                                    " es: " + producto.calcular(5));
        }

    }
}
