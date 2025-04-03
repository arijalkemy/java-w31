public class CircuitoMedio implements Circuito{
    @Override
    public int edadMinima() {
        return 0;
    }

    @Override
    public int precioMenor() {
        return 2000;
    }

    @Override
    public int precioMayor() {
        return 2300;
    }

    @Override
    public String nombre() {
        return "Circuito medio";
    }
}
