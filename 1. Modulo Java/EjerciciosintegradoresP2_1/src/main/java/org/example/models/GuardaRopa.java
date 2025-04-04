package org.example.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> mapa = new HashMap<>();
    private int contador = 0;

    public GuardaRopa() {
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        this.mapa.put(this.contador, prendas);
        System.out.println("Su ropa ha sido guardada bajo el id: " + this.contador);
        this.contador++;
        return this.contador;
    }

    public void mostrarPrendas(){
        mapa.forEach((k, v) -> {
            System.out.println("ID: "+k );

            v.forEach(prenda -> {
                System.out.println("------------Prenda-----------" + "\nMarca: "+ prenda.getMarca()+"\nModelo: "+prenda.getModelo());
            });
            System.out.println("***********************************");
        });
    }

    public List<Prenda> devolverPrendas(Integer id) throws Exception {

        if(id<this.contador && id>=0){
            System.out.println("ID BUSCADO: "+id);
            this.mapa.get(id).forEach(prenda -> {
                System.out.println("--------------------Prendas encontradas--------------"+"\nMarca: "+ prenda.getMarca()+"\nModelo: "+prenda.getModelo());
            });
        }else{
            throw new Exception("El id que ingresó no existe.");
        }

        return this.mapa.get(id);
    }
}
