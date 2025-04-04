package savetheropa;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear guardarropa
        Guardaropa guardaropa = new Guardaropa();

        // Crear dos prendas
        Prenda prenda1 = new Prenda("Nike", 101, "Rojo");
        Prenda prenda2 = new Prenda("Adidas", 202, "Azul");

        // Guardar las prendas y recibir los códigos
        System.out.println("Guardando prendas...");
        guardaropa.agregarPrendas(List.of(prenda1, prenda2));

        // Consultar prendas guardadas
        System.out.println("\nConsultando todas las prendas guardadas:");
        guardaropa.mostrarPrendas();

        // Consultar una prenda específica por su código
        int codigoConsulta = 101;
        System.out.println("\nRecuperando prenda con código " + codigoConsulta + ":");
        List<Prenda> prendasRecuperadas = guardaropa.devolverPrendas(codigoConsulta);
        if (!prendasRecuperadas.isEmpty()) {
            prendasRecuperadas.forEach(prenda -> 
                System.out.println(prenda.getMarca() + " " + prenda.getModelo() + " (" + prenda.getColor() + ")")
            );
        } else {
            System.out.println("No se encontró la prenda con código " + codigoConsulta);
        }
    }
}
