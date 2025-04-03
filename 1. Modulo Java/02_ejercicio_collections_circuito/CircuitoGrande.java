public class CircuitoGrande implements Circuito{
    @Override
    public int edadMinima() {
        return 18;
    }

    @Override
    public int precioMenor() {
        return 0;
    }

    @Override
    public int precioMayor() {
        return 2800;
    }

    @Override
    public String nombre() {
        return "Circuito grande";
    }
}
