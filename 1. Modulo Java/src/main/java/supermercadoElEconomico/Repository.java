package supermercadoElEconomico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository<T extends Identificable<ID>, ID> {
    private final Map<ID, T> database = new HashMap<>();

    public void save(T entidad) {
        ID id = entidad.getID();
        database.put(id, entidad);
    }

    public T findById(ID id) {
        return database.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(database.values());
    }

    public void update(T entidad) {
        ID id = entidad.getID();
        if(database.containsKey(id)) {
            database.put(id, entidad);
        }
    }

    public void delete(ID id) {
        database.remove(id);
    }
}
