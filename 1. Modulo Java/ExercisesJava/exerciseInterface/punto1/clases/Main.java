package exerciseInterface.punto1.clases;

public class Main {
    public static void main(String[] args) {
        Basico basico = new Basico();
        Cobradores cobradores = new Cobradores();
        Ejecutivo ejecutivo = new Ejecutivo();

        System.out.println(" Ejecutivo" + ejecutivo.Depositar());
        System.out.println("Basico" + basico.pagoService());
        System.out.println("Cobrador "+ cobradores.consultaSaldo());
    }
}
