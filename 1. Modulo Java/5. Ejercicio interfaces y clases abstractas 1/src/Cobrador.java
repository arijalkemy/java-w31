class Cobrador {
    public void realizarRetiro() {
        Transaccion retiro = new RetiroEfectivo();
        retiro.transaccionOk();
    }

    public void realizarConsultaSaldo() {
        Transaccion consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }
}