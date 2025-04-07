class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se ha podido realizar el retiro de efectivo.");
    }
}
