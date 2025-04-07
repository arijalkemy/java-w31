import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }
}
