
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Integer contador;
    private Map<Integer, List<Prenda>> prendas;

    public GuardaRopa() {
        this.contador = 0;
        this.prendas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.prendas.put(contador, listaDePrenda);
        System.out.println("Guardado: " + contador + " " + listaDePrenda);
        return contador++;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer, List<Prenda>> entry : this.prendas.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.prendas.get(numero);
    }

}