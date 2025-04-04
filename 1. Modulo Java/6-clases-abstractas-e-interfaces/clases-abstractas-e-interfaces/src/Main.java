import Model.Ejercicio1.Cliente.Basico;
import Model.Ejercicio1.Cliente.Cobrador;
import Model.Ejercicio1.Cliente.Ejecutivo;
import Model.Ejercicio2.Documentos.Curriculum;
import Model.Ejercicio2.Documentos.Informe;
import Model.Ejercicio2.Documentos.Libro;
import Model.Ejercicio2.Impresora;
import Model.Ejercicio3.Animales.Gato;
import Model.Ejercicio3.Animales.Perro;
import Model.Ejercicio3.Animales.Vaca;
import Model.Ejercicio3.Zoologico;

public class Main {
    public static void main(String[] args) {

        /* *************************************************** */
        /* ******************* EJERCICIO 1 ******************* */
        /* *************************************************** */

        System.out.println(" *************************************************** \n ******************* EJERCICIO 1 ******************* \n *************************************************** ");

        // Ejecutivos: Realizan Depósitos y Transferencias.
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito();
        ejecutivo.hacerTransferencia();
        System.out.println("Codigo cliente " + ejecutivo.getCodigoCliente());

        // Básico: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
        Basico basico = new Basico();
        basico.consultarSaldo();
        basico.pagarServicios();
        basico.retirarEfectivo();

        // Cobradores: Realizan retiro de efectivo y consulta de saldos.
        Cobrador cobrador = new Cobrador();
        cobrador.retirarEfectivo();
        cobrador.consultarSaldo();

        /* *************************************************** */
        /* ******************* EJERCICIO 2 ******************* */
        /* *************************************************** */

        System.out.println("\n\n *************************************************** \n ******************* EJERCICIO 2 ******************* \n *************************************************** ");

        Curriculum curriculum = new Curriculum();
        Informe informe = new Informe();
        Libro libro = new Libro();

        Impresora.imprimir(curriculum);
        Impresora.imprimir(informe);
        Impresora.imprimir(libro);

        /* *************************************************** */
        /* ******************* EJERCICIO 3 ******************* */
        /* *************************************************** */

        System.out.println("\n\n *************************************************** \n ******************* EJERCICIO 3 ******************* \n *************************************************** ");
        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        Perro perro = new Perro();

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierva();

        /* Como propuesta extra se sugiere llamar a un metodo comerAnimal
        donde a partir del pasaje de un objeto de cualquier tipo de animal como parámetro,
        invoque al metodo para comer según corresponda a dicho animal.
         */

        System.out.println("Zoologico");

        Zoologico.comerAnimal(gato);
        Zoologico.comerAnimal(perro);
        Zoologico.comerAnimal(vaca);

        /*
        public static String comerAnimal(Animal animal) {
            if (animal instanceof Gato) {
                return ((Gato) animal).comerCarne();
            } else if (animal instanceof Perro) {
                return ((Perro) animal).comerCarne();
            } else if (animal instanceof Vaca) {
                return ((Vaca) animal).comerHierba();
            }
            return "";
        }
         */
    }
}