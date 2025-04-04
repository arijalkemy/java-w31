package clase.POO.integrador2;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> lista ;
    private int contador;

    public GuardaRopa() {
        lista = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        lista.put(contador, listaDePrenda);
        return contador++;
    }
    public void mostrarPrendas(){
        lista.forEach((k,v)->{
            System.out.println("La lista de prendas del cliente "+k+" es: ");
            v.forEach(System.out::println);
        });
    }

    public void eliminarPrendas(Integer numero){
        lista.remove(numero);
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return lista.get(numero);
    }

    public HashMap<Integer, List<Prenda>> getLista() {
        return lista;
    }

    public void setLista(HashMap<Integer, List<Prenda>> lista) {
        this.lista = lista;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
