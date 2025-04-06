package guardarropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardarropa {
    private Map<Integer, List<Prenda>> guardado = new HashMap<>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> prendas) {
        contador++;
        guardado.put(contador, prendas);
        return contador;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> entrada : guardado.entrySet()) {
            Integer clave = entrada.getKey();
            List<Prenda> valor = entrada.getValue();

            System.out.println("La prenda se encuentra en el lugar: " + clave + " y posee: ");
            for (Prenda prenda : valor) {
                System.out.println("- " + prenda.getMarca() + " - " + prenda.getModelo());
            }
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return guardado.remove(numero);
    }
}
