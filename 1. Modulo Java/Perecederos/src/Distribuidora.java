public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[6];

        productos[0] = new Perecedero("Leche", 9000.0, 1); // 1 día para caducar
        productos[1] = new Perecedero("Pan", 5.0, 2);   // 2 días para caducar
        productos[2] = new Perecedero("Yogur", 7.0, 3); // 3 días para caducar

        productos[3] = new NoPerecedero("Arroz", 20.0, "Grano");
        productos[4] = new NoPerecedero("Harina", 15.0, "Grano");
        productos[5] = new NoPerecedero("Aceite", 30.0, "Aceite");

        double totalPerecederos = 0;
        double totalNoPerecederos = 0;

        for (int i = 0; i < 3; i++) {
            totalPerecederos += productos[i].Calcular(5);
        }

        for (int i = 3; i < 6; i++) {
            totalNoPerecederos += productos[i].Calcular(5);
        }

        System.out.println("Total precio de los productos perecederos: " + totalPerecederos);
        System.out.println("Total precio de los productos no perecederos: " + totalNoPerecederos);
    }
}
