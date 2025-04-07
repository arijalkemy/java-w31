package bootcamp.integrador_mañana;

public interface ClientRepository {
    void agrear(Cliente cliente);
    void eliminar(Cliente cliente);
    boolean buscarCliente(Cliente cliente);
}
