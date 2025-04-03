import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer identificador;

    public GuardaRopa() {
        prendas = new HashMap<>();
        identificador = 0;
    }
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        identificador++;
        prendas.put(identificador, listaDePrenda);
        return identificador;
    }

    public void mostrarPrendas() {
        System.out.println("---PRENDAS GUARDADAS---");
        if (prendas.isEmpty()) {
            System.out.println("No hay prendas guardadas");
        }
        else {
            for (Map.Entry<Integer, List<Prenda>> entry : prendas.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().toString());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendasADevolver = prendas.get(numero);
        if (prendasADevolver == null) {
            return null;
        }
        prendas.remove(numero);
        System.out.println("Devolviendo prendas...\n");
        return prendasADevolver;
    }
}
