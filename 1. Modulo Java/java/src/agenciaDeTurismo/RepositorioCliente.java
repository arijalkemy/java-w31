package agenciaDeTurismo;

import java.util.*;

public class RepositorioCliente {
    private Map<String, List<Localizador>> clientes = new HashMap<>();

    public void agregarLocalizador(Localizador localizador) {
        clientes.computeIfAbsent(localizador.getCliente(), k -> new ArrayList<>()).add(localizador);
    }

    public int cantidadLocalizadores(String cliente) {
        return clientes.getOrDefault(cliente, Collections.emptyList()).size();
    }
}
