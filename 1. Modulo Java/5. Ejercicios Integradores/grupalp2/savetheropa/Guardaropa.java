package savetheropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Guardaropa {

    private final Map<Integer, Prenda> prendas;
    private int cantidadPrendas;

    public Guardaropa() {
        this.prendas = new HashMap<>();
        this.cantidadPrendas = 0;
    }

    public void agregarPrendas(List<Prenda> prendas) {
        for (Prenda prenda : prendas) {
            agregarPrenda(prenda);
        }
    }

    private void agregarPrenda(Prenda prenda) {
        int modelo = prenda.getModelo();
        if (!prendas.containsKey(modelo)) {
            prendas.put(modelo, prenda);
            cantidadPrendas++;
        } else {
            System.out.println("La prenda " + modelo + " ya existe en el guardaropa.");
        }
    }

    public void eliminarPrenda(int modelo) {
        if (prendas.containsKey(modelo)) {
            prendas.remove(modelo);
            cantidadPrendas--;
            System.out.println("Prenda eliminada del guardaropa.");
        } else {
            System.out.println("La prenda no existe en el guardaropa.");
        }
    }

    public void mostrarPrendas() {
        if (prendas.isEmpty()) {
            System.out.println("El guardaropa está vacío.");
        } else {
            System.out.println("Prendas en el guardaropa:");
            prendas.values().forEach(prenda ->
                System.out.println("- " + prenda.getMarca() + " " + prenda.getModelo() + " (" + prenda.getColor() + ")")
            );
        }
    }

    public List<Prenda> devolverPrendas(int modelo) {
        return prendas.containsKey(modelo) ? List.of(prendas.get(modelo)) : List.of();
    }

    public int getCantidadPrendas() {
        return cantidadPrendas;
    }
}
