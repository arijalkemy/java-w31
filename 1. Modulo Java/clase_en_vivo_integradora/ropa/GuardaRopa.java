package ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    Map <String, Prenda> prendas;
    private int contadorPrendas;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contadorPrendas = 0;
    }

    public Integer guardarPrendas(List<Prenda> listadePrenda) {
        listadePrenda.stream().forEach(
            prenda -> {
                prendas.put("Prenda-" + contadorPrendas, prenda);
                contadorPrendas++;
            }
        );
        return contadorPrendas;
    }

    public void mostrarPrendas() {
        System.out.println("Lista de prendas guardadas:");
        for (Map.Entry<String, Prenda> entry : prendas.entrySet()) {
            String key = entry.getKey();
            Prenda value = entry.getValue();
            System.out.println(key + " : " + value.getMarca() + " " + value.getModelo());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        for (Prenda prenda : prendas.values()) {
            if (prenda.getId() == numero) {
                return List.of(prenda);
            }
        }
        return List.of();
    }
}
