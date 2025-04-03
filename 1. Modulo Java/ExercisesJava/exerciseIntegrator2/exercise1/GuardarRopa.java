package exerciseIntegrator2.exercise1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardarRopa {
    private Map<Integer, List<Prenda>>  guardarRopa = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        Integer keyId = guardarRopa.size() + 1;
        this.guardarRopa.put(keyId, listaDePrenda);
        return keyId;

    }

    public void mostrarPrendas() {
        guardarRopa.forEach((keyId, listaDePrenda) -> {
            System.out.println(keyId);
            listaDePrenda.stream().forEach(System.out :: println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return guardarRopa.get(numero);
        
    }

}
