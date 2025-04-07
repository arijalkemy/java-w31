import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendasMap;
    private Integer contador;

    public GuardaRopa() {
        this.prendasMap = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        this.contador++;
        prendasMap.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entry : prendasMap.entrySet()) {
            System.out.println("Número: " + entry.getKey() + " - Prendas: " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return prendasMap.remove(numero);
    }
}
