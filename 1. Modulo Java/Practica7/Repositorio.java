package Practica7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Repositorio {
    private HashMap<Cliente, List<Localizador> > repositorio ;

    public Repositorio( ) {
        this.repositorio = new HashMap<>();
 ;   }
    public void registrarLocalizador( Cliente c , Localizador l ){

        if(this.repositorio.containsKey(c)){
            List lisLocalizadorCliente = new ArrayList(this.repositorio.get(c));
            lisLocalizadorCliente.add(l);
            this.repositorio.put(c , lisLocalizadorCliente);
        }else{
        List lisLocalizadorCliente = List.of(l);
            this.repositorio.put(c , lisLocalizadorCliente);
        }
    }

    public String mostrarRepositorio( ){
        return toString();
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "repositorio=" + repositorio +
                '}';
    }
}
