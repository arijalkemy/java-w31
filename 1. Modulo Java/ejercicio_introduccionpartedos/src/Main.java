import java.util.*;

public class Main {
    private static final List<Category> categories = new ArrayList<>();
    private static final List<Participant> participants = new ArrayList<>();
    private static List<Inscription> inscriptions = new ArrayList<>();

    public static void main(String[] args) {
        initialData();
        printAllInscriptions();
        inscriptions.remove(2);
        printAllInscriptions();
        double totalCarrera = inscriptions.stream().mapToDouble(Inscription::getPrice).sum();
        System.out.println("totalCarrera = " + totalCarrera);
    }

    private static void printAllInscriptions() {
        Collections.sort(inscriptions, Comparator.comparing(inscription -> inscription.getCategory().getName()));
        for (Inscription inscription : inscriptions) {
            System.out.println("Número de inscripcion: " + inscription.getId());
            System.out.println("Categoria: " + inscription.getCategory().getName() + " - " + inscription.getCategory().getDescription());
            System.out.println("Participante: " + inscription.getParticipant().getName());
        }
    }

    private static void initialData() {  
        categories.add(new Category("Circuito chico", "2 km por selva y arroyos", Map.of(age -> age < 18, 1300.0, age -> age >= 18, 1500.0)));
        categories.add(new Category("Circuito medio", "5 km por selva, arroyos y barro", Map.of(age -> age < 18, 2000.0, age -> age >= 18, 2300.0)));
        categories.add(new Category("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra", Map.of(age -> age >= 18, 2800.0)));

        participants.add(new Participant("1001", "Juan", "Pérez", 16, 3101234567L, 3107654321L, "O+"));
        participants.add(new Participant("1002", "Ana", "Gómez", 17, 3201234567L, 3207654321L, "A-"));
        participants.add(new Participant("1003", "Luis", "Martínez", 15, 3301234567L, 3307654321L, "B+"));
        participants.add(new Participant("1004", "Sofía", "Rodríguez", 14, 3401234567L, 3407654321L, "AB-"));
        participants.add(new Participant("1005", "Carlos", "Fernández", 13, 3501234567L, 3507654321L, "O-"));
        participants.add(new Participant("1006", "María", "López", 20, 3601234567L, 3607654321L, "A+"));
        participants.add(new Participant("1007", "Pedro", "Díaz", 22, 3701234567L, 3707654321L, "B-"));
        participants.add(new Participant("1008", "Laura", "Ramírez", 19, 3801234567L, 3807654321L, "AB+"));
        participants.add(new Participant("1009", "Jorge", "Torres", 21, 3901234567L, 3907654321L, "O+"));
        participants.add(new Participant("1010", "Elena", "Castro", 25, 4001234567L, 4007654321L, "A-"));

        Random random = new Random();
        Collections.shuffle(participants);
        for (Participant participant : participants) {
            try {
                Category randomCategory = categories.get(random.nextInt(categories.size()));
                inscriptions.add(new Inscription(randomCategory, participant));
                setParticipantCategory(participant, randomCategory);
            } catch (Exception _) {
            }
        }
        inscriptions.sort(Comparator.comparingInt(Inscription::getId));
        participants.sort(Comparator.comparingInt(Participant::getId));
    }

    public static void setParticipantCategory(Participant participant, Category category) throws Exception {
        if (participant.getCategory_id() == null) {
            participant.setCategory_id(category.getId());
        } else {
            throw new Exception("El participante ya esta inscrito en una categoria");
        }
    }


    public static void printParticipants(List<Participant> participants) {
        for (Participant participant : participants) {
            System.out.println("\t" + participant.getId() + "- DNI " + participant.getDni() + " " + participant.getName() + ", " + participant.getAge());
        }
    }

}