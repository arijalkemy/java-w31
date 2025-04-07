package bootcamp.integrador_tarde.guarda_ropa;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> guardaRopas = new HashMap<>();
    private int idGuardaRopa = 0;

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        guardaRopas.put(idGuardaRopa++, listaPrendas);
        return idGuardaRopa;
    }

    public void mostrarPrendas() {
        guardaRopas.forEach( (id, listaPrendas) -> {
            listaPrendas.forEach(c -> {
                System.out.println(c.toString());
            });
        });
    }

    public List<Prenda> devolverPrendas(Integer id) {
        return guardaRopas.get(id);
    }
}
