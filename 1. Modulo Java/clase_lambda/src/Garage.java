import java.util.List;
import java.util.ArrayList;

public class Garage <E>{
    public int id;
    List<E> lista_vehiculos = new ArrayList<>();

    public Garage(int id, List<E> lista_vehiculos) {
        this.id = 0;
        this.lista_vehiculos = lista_vehiculos;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public List<E> getListaVehiculos(){
        return this.lista_vehiculos;
    }
    public void setListaVehiculos(List<E> lista){
        this.lista_vehiculos = lista;
    }
}
