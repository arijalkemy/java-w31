package Practica8;

import Practica7.Cliente;
import Practica7.Localizador;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {


    private HashMap<Integer, List<Prenda>> lista ;
    private int contador;

    public GuardaRopa() {
        this.lista = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> ls){
        this.contador+=1;
        this.lista.put(this.contador, ls);
        return this.contador;
    }

    public void mostrarPrendas(){
        System.out.println(toString());

    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.lista.get(numero);
    }

    public List<Prenda> devolverPrendas(Integer numero){

        List<Prenda> prendas = diccionario.remove(numero);
        return prendas;
    }


    @Override
    public String toString() {
        return "GuardaRopa{" +
                "lista=" + lista +
                ", contador=" + contador +
                '}';
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
