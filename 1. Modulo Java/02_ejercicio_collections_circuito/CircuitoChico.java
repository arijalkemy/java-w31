public class CircuitoChico implements Circuito {
    @Override
    public int edadMinima() {
        return 0;
    }

    @Override
    public int precioMenor() {
        return 1300;
    }

    @Override
    public int precioMayor() {
        return 1500;
    }
    @Override
    public String nombre() {
        return "Circuito chico";
    }
}
