package EjerciciosIntegradores.SaveTheRopaSA;

import java.util.HashMap;
import java.util.List;

public class Guardaropas {
    private HashMap<Integer, List<Prenda>> guardaropas;
    private static Integer contador =  0;

    public Guardaropas() {
        this.guardaropas = new HashMap<>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;
        guardaropas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        for (Integer key : guardaropas.keySet()) {
            System.out.print("Número: " + key + ", Prendas: ");
            guardaropas.get(key).forEach(p -> System.out.print("Modelo: " + p.getModelo() + ", Marca: " + p.getMarca()));
            System.out.println();
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return guardaropas.get(numero);
    }
}
