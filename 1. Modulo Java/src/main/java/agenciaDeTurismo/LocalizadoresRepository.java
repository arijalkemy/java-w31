package agenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class LocalizadoresRepository {
    private final List<Localizadora> localizadores;

    public LocalizadoresRepository() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizadora> getLocalizadoresByCliente(String clientID) {
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(clientID)).toList();
    }

    public int getClienteAmountofLocalizadores(String clientID) {
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(clientID)).toList().size();
    }

    public List<Localizadora> getLocalizadores() {
        return localizadores;
    }

    public void storeLocalizador(Localizadora localizadora) {
        this.localizadores.add(localizadora);
    }
}
