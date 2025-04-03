package repository;

import modelos.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository {
    private static final List<Localizador> localizadores = new ArrayList<>();
    private static LocalizadorRepository instance;
    private LocalizadorRepository() {}
    public static LocalizadorRepository getInstance() {
        if (instance == null) {
            instance = new LocalizadorRepository();
        }
        return instance;
    }

    public void agregarLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }

    public long obtenerCantidadLocalizadores(long clienteDni){
        return localizadores.stream().filter(localizador -> localizador.getCliente().getDni() == clienteDni).count();
    }
}
