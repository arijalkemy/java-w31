package EJINT_SupermercadoElEconomico;

public interface CRUD<T> {
    void crear(T t);
    T leer(String id);
    void actualizar(T t);
    void eliminar(String id);
}
