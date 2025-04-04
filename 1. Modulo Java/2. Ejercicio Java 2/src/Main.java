//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Map<String, String>> categories = new ArrayList<>();
        categories.add(new HashMap<>() {{
            put("id", "Circuito 1");
            put("nombre", "Circuito chico");
            put("descripcion", "2 km por selva y arroyos.");
        }});
        categories.add(new HashMap<>() {{
            put("id", "Circuito 2");
            put("nombre", "Circuito medio");
            put("descripcion", "5 km por selva, arroyos y barro.");
        }});
        categories.add(new HashMap<>() {{
            put("id", "Circuito 3");
            put("nombre", "Circuito avanzado");
            put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");
        }});
        List<Map<String, String>> inscripciones = new ArrayList<>();

        Map<String, String> participante1 = new HashMap<>(){{
            put("Numero", "1");
            put("CC", "1232452323");
            put("Nombre", "Alberto");
            put("Apellido", "Posada");
            put("edad","14");
            put("celular","3233749876");
            put("emergencia","3236786787");
            put("Sangre","O+");
        }};

        Map<String, String> participante2 = new HashMap<>(){{
            put("Numero", "2");
            put("CC", "1232458765");
            put("Nombre", "Alvaro");
            put("Apellido", "Casillas");
            put("edad","30");
            put("celular","3233741967");
            put("emergencia","3206098787");
            put("Sangre","O-");
        }};

        Map<String, String> participante3 = new HashMap<>(){{
            put("Numero", "3");
            put("CC", "9812352323");
            put("Nombre", "Jairo");
            put("celular","3153349876");
            put("emergencia","3200516787");
            put("Sangre","A+");
        }};
    }
}