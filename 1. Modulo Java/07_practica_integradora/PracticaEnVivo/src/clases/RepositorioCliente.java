package clases;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    List<Localizador> historialLocalizadores = new ArrayList<>();
    public  RepositorioCliente(){

    }

    public void add(Localizador loc){
        historialLocalizadores.add(loc);
    }
    public List<Localizador> getHistorialLocalizadores(){
        return historialLocalizadores;
    }
    public void adquirioDos(Client cliente){
        cliente.setTieneDescuento(historialLocalizadores.stream().filter(cli -> cli.cliente.getDni().equals(cliente.getDni())).count() >= 2);
    }



}
