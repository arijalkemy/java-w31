class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no ha podido ser realizada.");
    }
}
