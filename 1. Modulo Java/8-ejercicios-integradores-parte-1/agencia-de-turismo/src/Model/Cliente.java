package Model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private List<Localizador> localizadores = new ArrayList<>();

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void addLocalizador(Localizador l) {
        localizadores.add(l);
    }

    public boolean tieneAlMenos2Localizadores() {
        return localizadores.size() >= 2;
    }
}
