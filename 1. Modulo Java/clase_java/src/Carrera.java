import java.util.HashMap;
import java.util.Map;

public class Carrera {
    public static void main(String[] args) {
        String[][] circuitos = {
            {"Circuito chico", "2km por selva y arroyos"},
            {"Circuito medio", "5km por selva, arroyos y barro."},
            {"Circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra"}
        };
        
        Map<String, Map<Integer, Integer>> circuito_chico_menores = new HashMap<>();
        Map<String, Map<Integer, Integer>> circuito_chico_mayores = new HashMap<>();
        Map<String, Map<Integer, Integer>> circuito_medio_menores = new HashMap<>();
        Map<String, Map<Integer, Integer>> circuito_medio_mayores = new HashMap<>();
        Map<String, Map<Integer, Integer>> circuito_avanzado_mayores = new HashMap<>();
        
        int inscripcion;
        int totalChico = 0;
        int totalMedio = 0;
        int totalAvanzado = 0;
        int totalRecaudado = 0;

        String[][] participantesInfo = {
            {"Juan", "Chico"},
            {"Maria", "Chico"},
            {"Pedro", "Medio"},
            {"Ana", "Chico"},
            {"Luis", "Medio"},
            {"Mateo", "Avanzado"},
            {"Martin", "Avanzado"}
        };
        int edades[] = {16, 23, 42, 14, 62, 32, 15};

        for (int i = 0; i < edades.length; i++){
            if (participantesInfo[i][1].equals("Chico")){
                if (edades[i] < 18){
                    inscripcion = 1300;
                    totalChico += inscripcion;
                    totalRecaudado += inscripcion;
                    Map<Integer, Integer> participantData = new HashMap<>();
                    participantData.put(edades[i], inscripcion);
                    circuito_chico_menores.put(participantesInfo[i][0], participantData);
                }
                else {
                    inscripcion = 1500;
                    totalChico += inscripcion;
                    totalRecaudado += inscripcion;
                    Map<Integer, Integer> participantData = new HashMap<>();
                    participantData.put(edades[i], inscripcion);
                    circuito_chico_mayores.put(participantesInfo[i][0], participantData);
                }
            }
            else {
                if (participantesInfo[i][1].equals("Medio")) {
                    if (edades[i] < 18) {
                        inscripcion = 2000;
                        totalMedio += inscripcion;
                        totalRecaudado += inscripcion;
                        Map<Integer, Integer> participantData = new HashMap<>();
                        participantData.put(edades[i], inscripcion);
                        circuito_medio_menores.put(participantesInfo[i][0], participantData);
                    }
                    else {
                        inscripcion = 2300;
                        totalMedio += inscripcion;
                        totalRecaudado += inscripcion;
                        Map<Integer, Integer> participantData = new HashMap<>();
                        participantData.put(edades[i], inscripcion);
                        circuito_medio_mayores.put(participantesInfo[i][0], participantData);
                    }
                }
                if (participantesInfo[i][1].equals("Avanzado")) {
                    if (edades[i] < 18) {
                        System.out.println("El participante: " + participantesInfo[i][0] + " no puede participar ya que tiene " + edades[i] + " años.");
                        participantesInfo[i] = null;
                        edades[i] = -1;
                        System.out.println("Los participantes del circuito avanzado son ahora: " + circuito_avanzado_mayores);
                    }
                    else {
                        inscripcion = 2800;
                        totalAvanzado += inscripcion;
                        totalRecaudado += inscripcion;
                        Map<Integer, Integer> participantData = new HashMap<>();
                        participantData.put(edades[i], inscripcion);
                        circuito_avanzado_mayores.put(participantesInfo[i][0], participantData);
                    }
                }
            }
        }
        
        for (int i = 0; i < circuitos.length; i++) {
            System.out.println("\n " + circuitos[i][0] + "\n " + circuitos[i][1]);
            if(circuitos[i][0].equals("Circuito chico")){
                System.out.println("Los participantes de circuito chico menores son: ");
                circuito_chico_menores.forEach((name, data) -> data.forEach((age, fee) -> System.out.println("Nombre: " + name + ", Edad: " + age)));
                System.out.println("Los participantes de circuito chico mayores son: ");
                circuito_chico_mayores.forEach((name, data) -> data.forEach((age, fee) -> System.out.println("Nombre:" + name + ", Edad: " + age)));
            }
            else {
                if(circuitos[i][0].equals("Circuito medio")){
                    System.out.println("Los participantes de circuito medio menores son:");
                    circuito_medio_menores.forEach((name, data) -> 
                        data.forEach((age, fee) -> 
                            System.out.println("Nombre: " + name + ", Edad: " + age)));
                    System.out.println("Los participantes de circuito medio mayores son:");
                    circuito_medio_mayores.forEach((name, data) -> 
                        data.forEach((age, fee) -> 
                            System.out.println("Nombre: " + name + ", Edad: " + age)
                        )
                    );
                }
                else {
                    System.out.println("Los participantes de circuito medio mayores son: ");
                    circuito_medio_mayores.forEach((name, data) -> data.forEach((age, fee) -> System.out.println("Nombre: " + name + ", Edad: " + age)));
                }
            }
        }
        System.out.println("\nTotal recaudado en el circuito chico: $" + totalChico);
        System.out.println("\nTotal recaudado en el circuito medio: $" + totalMedio);
        System.out.println("\nTotal recaudado en el circuito avanzado: $" + totalAvanzado);
        System.out.println("\nTotal recaudado en todo el evento: $" + totalRecaudado);
    }
}
