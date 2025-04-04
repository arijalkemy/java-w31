//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Creando Array de productos
        ArrayList<Producto> productos = new ArrayList<>();
        double total = 0;

        Producto producto1 = new Perecedero("Banano", 200.0, 3);
        Producto producto2 = new Perecedero("Mango", 300.0, 3);
        Producto producto3 = new Perecedero("Piña", 400.0, 3);
        Producto producto4 = new NoPerecedero("Salchichas", 500.0, "Embutido");
        Producto producto5 = new NoPerecedero("Sardinas", 600.0, "Enlatado");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);

        for (Producto producto : productos) {
            total += producto.getCalculo(1);
        }

        System.out.println(total);
    }
}
