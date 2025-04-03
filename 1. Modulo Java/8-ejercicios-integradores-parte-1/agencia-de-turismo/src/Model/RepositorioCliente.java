package Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioCliente {
    Map<String, List<Localizador>> clientes = new HashMap<>();

    public List<Localizador> getLocalizadores(String idCliente) {
        return clientes.get(idCliente);
    }


}
