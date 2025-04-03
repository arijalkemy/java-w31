package Practica5;

public class Basic extends Cliente{

    private ConsultaDeSaldo consultaSaldo = new ConsultaDeSaldo();
    private RetiroDeEfectivo retirarEfectivo = new RetiroDeEfectivo();
    private PagoDeServicio pagoDeServicio = new PagoDeServicio();
    public Basic(String nombre, int id) {
        super(nombre, id);
    }

    @Override
    public void realizarOperacion() {
        consultaSaldo.transaccionOk();
        retirarEfectivo.transaccionNoOk();
        pagoDeServicio.transaccionNoOk();
    }
}
