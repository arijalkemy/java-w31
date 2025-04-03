package EjerciciosIntegradores.SupermercadoElEconomico.Bonus;

import java.util.List;

public interface CRUD<T> {
    public void alta(T t);
    public T consulta(Long id);
    public void modificacion(T t);
    public void baja(Long id);
    public void imprimir();
    public List<T> getTodos();
}