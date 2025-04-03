package EjerciciosIntegradores.AgenciaDeTurismo.Version1;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {
    private final List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public List<Localizador> getLocalizadoresByCliente(String clientID) {
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(clientID)).toList();
    }

    public int getClienteAmountofLocalizadores(String clientID) {
        return localizadores.stream().filter(l -> l.getCliente().getDni().equals(clientID)).toList().size();
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void storeLocalizador(Localizador localizadora) {
        if(localizadores.stream().filter(l -> l.getCliente().getDni().equals(localizadora.getCliente().getDni())).count() >= 2) {
            localizadora.aplicarDescuento(0.05);
        }

        this.localizadores.add(localizadora);
    }
}
