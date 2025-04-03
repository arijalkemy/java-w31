package Model;

import Model.Prendas.Prenda;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class GuardaRopa {

    private HashMap<UUID, List<Prenda>> guardaRopa = new HashMap<>();

    public GuardaRopa() {
    }

    public UUID guardarPrendas(List<Prenda> listaDePrenda) {
        UUID uuid = UUID.randomUUID();
        guardaRopa.put(uuid, listaDePrenda);
        System.out.println("Se guardaron las prendas bajo la clave: " + uuid);
        return uuid;
    }

    public void mostrarPrendas() {
        guardaRopa.entrySet().stream().forEach(e -> {
            String prendas = e.getValue().stream()
                    .map(prenda -> prenda.toString())
                    .collect(Collectors.joining(", "));
            System.out.println(e.getKey() + ": " + prendas);
        });
    }

    public List<Prenda> devolverPrendas(UUID id) {
        return guardaRopa.remove(id);
    }

}
