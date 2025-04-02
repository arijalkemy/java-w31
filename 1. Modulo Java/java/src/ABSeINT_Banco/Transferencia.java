
package ABSeINT_Banco;
public class Transferencia implements Ejecutivo.Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la transferencia.");
    }
}