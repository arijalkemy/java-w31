public class Main {
    public static void main(String[] args) {
        PracticaExcepciones pex = new PracticaExcepciones();

        // Ejercicio 1
        // pex.cociente1_1();
        // pex.cociente1_2();

        // Ejercicio 4
        NoPerecedero arroz = new NoPerecedero("Arroz", 2000, "Grano");
        NoPerecedero fideos = new NoPerecedero("Fideos", 1800, "Pasta");
        NoPerecedero lentejas = new NoPerecedero("Lentejas", 2200, "Legumbre");
        NoPerecedero harina = new NoPerecedero("Harina", 1600, "Harina");
        NoPerecedero sal = new NoPerecedero("Sal", 900, "Condimento");

        Perecedero leche = new Perecedero("Leche", 1500, 5);
        Perecedero carne = new Perecedero("Carne", 4500, 3);
        Perecedero pollo = new Perecedero("Pollo", 4200, 4);
        Perecedero pescado = new Perecedero("Pescado", 5000, 2);
        Perecedero queso = new Perecedero("Queso", 3800, 10);

        Producto[] productos = {arroz, fideos, lentejas, harina, sal, leche, carne, pollo, pescado, queso};

        int cantidad = 5;
        double total = 0;
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Venta de: " + productos[i].getNombre() + "\t\t\t\t precio: " + productos[i].calcular(cantidad));
            total += productos[i].calcular(cantidad);
        }
        System.out.println("Total: " + total);
    }
}