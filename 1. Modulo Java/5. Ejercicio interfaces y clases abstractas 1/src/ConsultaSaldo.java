class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta de saldo no ha podido ser realizada.");
    }
}
