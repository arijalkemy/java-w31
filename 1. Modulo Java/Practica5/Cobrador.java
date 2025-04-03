package Practica5;

public class Cobrador extends Cliente{

    private ConsultaDeSaldo consultaSaldo = new ConsultaDeSaldo();
    private RetiroDeEfectivo retirarEfectivo = new RetiroDeEfectivo();
    public Cobrador(String nombre, int id) {
        super(nombre, id);
    }

    @Override
    public void realizarOperacion() {
            consultaSaldo.transaccionOk();
            retirarEfectivo.transaccionNoOk();
    }
}
