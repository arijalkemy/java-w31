package ejercicio_turismo.Repository;

import java.util.HashMap;

public interface Repositorio<T> {
    void guardar(T obj);

    HashMap<Integer, T> getAll();
}
