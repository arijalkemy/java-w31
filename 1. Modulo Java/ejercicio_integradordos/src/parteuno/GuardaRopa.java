package parteuno;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private final Map<Integer, List<Prenda>> guardarRopas;
    private int contador = 0;

    public GuardaRopa() {
        guardarRopas = new HashMap<>();
        contador++;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        guardarRopas.put(contador, listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas() {
        guardarRopas.forEach((key, value) -> {
            System.out.println("Id: " + key);
            value.forEach(prenda -> System.out.println("Prenda: " + prenda));
        });
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return guardarRopas.get(numero);
    }
}