import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {
        List<String> listaPersonas = new ArrayList<String>();
        listaPersonas.add("Cristiano Ronaldo");
        listaPersonas.add("Lionel Messi");

        for (int i = 0; i<listaPersonas.size(); i++) {
            System.out.println("Hola soy: " + listaPersonas.get(i));
        }

        List<String> listaFamosos = new LinkedList<String>();
        listaFamosos.add("Mirtha Legrand");
        listaFamosos.add(0, "Susana Gimenez");

        for (String person: listaFamosos) {
            System.out.println ("Hola soy: " + person);
        }

        Map<Integer, String> mapa = new HashMap<>();
        mapa.put(1, "uno");
        mapa.put(2, "dos");
        mapa.put(3, "tres");
        mapa.put(4,"cuatro");

        String valor = mapa.get(2);
        System.out.println(valor);
        mapa.remove(2);

        for (Map.Entry<Integer, String> entrada: mapa.entrySet()){
            Integer clave = entrada.getKey();
            String res = entrada.getValue();
            System.out.println("La clave es: " + clave + " El valor es: " + res);
        }
    }
}
