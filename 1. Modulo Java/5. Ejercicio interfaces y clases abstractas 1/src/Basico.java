class Basico {
    public void realizarRetiro() {
        Transaccion retiro = new RetiroEfectivo();
        retiro.transaccionOk();
    }

    public void realizarConsultaSaldo() {
        Transaccion consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }

    public void realizarPagoServicio() {
        Transaccion pago = new PagoServicios();
        pago.transaccionOk();
    }
}