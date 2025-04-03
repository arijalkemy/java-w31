package ejercicio_turismo.Repository;

import java.util.HashMap;

import ejercicio_turismo.Model.Localizador;

public class RepositorioLocalizador implements Repositorio<Localizador> {
    private HashMap<Integer, Localizador> localizadores;

    public RepositorioLocalizador() {
        this.localizadores = new HashMap<>();
    }

    @Override
    public void guardar(Localizador obj) {
        if (obj != null) {
            localizadores.put(obj.getId(), obj);
        }
    }

    @Override
    public HashMap<Integer, Localizador> getAll() {
        return localizadores;
    }

}
