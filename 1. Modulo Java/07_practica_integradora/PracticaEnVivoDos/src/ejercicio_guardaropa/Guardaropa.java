package ejercicio_guardaropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropa {
    Map<Integer, List<Prenda>> guardaropa;
    Integer idContador;

    public Guardaropa() {
        this.guardaropa = new HashMap<>();
        this.idContador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        idContador +=1;
        guardaropa.put(idContador, listaDePrendas);
        return idContador;
    }

    public void mostrarPrenas(){
        guardaropa.forEach((id, pren) -> {
            System.out.println("Id: " + id + ". Prendas: " + pren);
        });
    }

    public List<Prenda> devolverPrendas(Integer id){
        return guardaropa.get(id);
    }
}
