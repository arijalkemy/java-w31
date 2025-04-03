package saveThePrendas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopas<T> {
    private Map<Integer, List<T>> prendas;
    private Integer contador;

    public GuardaRopas() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<T> prendas) {
        this.contador++;
        this.prendas.put(contador, prendas);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<T>> entry : this.prendas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public List<T> devolverPrendas(Integer id) {
        return this.prendas.remove(id);
    }
}
