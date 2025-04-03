package com.mercadolibre;

public interface CRUD<T> {
    void realizarAlta(T elemento);
    void eliminar (T elemento);
    void modificar(T elemento);
    T obtenerClientePorId(Integer id);

}

