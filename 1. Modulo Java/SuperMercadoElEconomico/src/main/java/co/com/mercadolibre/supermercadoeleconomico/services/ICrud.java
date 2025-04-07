package co.com.mercadolibre.supermercadoeleconomico.services;

import java.util.List;

public interface ICrud<T> {

    void create(T t);
    T read(String id); // Lectura por el identificador único (p.ej.: dni para Cliente o id para Factura)
    List<T> readAll();
    void update(T t);
    void delete(String id);
}
