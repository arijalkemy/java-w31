package exerciseRaceEstructuraDinamica;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Category shortCategory = new Category(0, "Circuito chico", "2 km por selva y arroyos");
        Category mediumCategory = new Category(1, "Circuito medio", "5 km por selva,arroyos y barro");
        Category avancedCategory = new Category(2, "Circuito avanzado",
                "10 km por selva,arroyos,barro y escalada en piedra");
        // Numeral B
        Participant participant = new Participant(12, 4567, "Marcos Antonio", "Cardenas", 21, "321456789", 123, "a+");
        // inscribir al participante
        Inscription inscription = new Inscription(1, shortCategory, participant);
        System.out.println("El monto a pagar para el participante:" + participant.getFirstName() + " es "
                + inscription.getAmount());

        // Numeral C
        Participant participant1 = new Participant(15, 457, "Maria Antonieta", "Cruz", 17, "32146789", 123, "o+");
        Participant participant2 = new Participant(16, 467, "Miller", "Coronel", 18, "32156789", 123, "ab+");
        Participant participant3 = new Participant(18, 456, "Lucas", "Lopez", 25, "32145679", 123, "o-");

        // Array para categorias

        ArrayList<Category> listSelectedCategories = new ArrayList<>();
        listSelectedCategories.add(shortCategory);
        listSelectedCategories.add(mediumCategory);
        listSelectedCategories.add(avancedCategory);

        // Array para seleccion categories

        ArrayList<Integer> listSelectedIndexCategories = new ArrayList<>();
        do {
            int randomNumber = (int) Math.floor(Math.random() * 3);
            if (!listSelectedIndexCategories.contains(randomNumber)) {
                listSelectedIndexCategories.add(randomNumber);
            }

        } while (listSelectedIndexCategories.size() != 3);

        Inscription saveInscription = new Inscription(3, listSelectedCategories.get(listSelectedIndexCategories.get(0)),
                participant1);
        Inscription saveInscription1 = new Inscription(5,
                listSelectedCategories.get(listSelectedIndexCategories.get(1)), participant2);
        Inscription saveInscription2 = new Inscription(6,
                listSelectedCategories.get(listSelectedIndexCategories.get(2)), participant3);

        // Lista de inscritos
        ArrayList<Inscription> lInscriptions = new ArrayList<>();
        lInscriptions.add(inscription);
        lInscriptions.add(saveInscription1);
        lInscriptions.add(saveInscription2);
        lInscriptions.add(saveInscription);

        // Numeral D
        int selectedCategoryIndex = 1;
        Category selectCategory = listSelectedCategories.get(selectedCategoryIndex);
        System.out.println("Categoria seleccionada: " + selectCategory.getNameCategory());
        ArrayList<Participant> listTemporalParticipant = new ArrayList<>();
        for (int i = 0; i < lInscriptions.size(); i++) {
            if (lInscriptions.get(i).category.idCategory == selectedCategoryIndex) {
                Participant dateParticipant = lInscriptions.get(i).participant;
                listTemporalParticipant.add(dateParticipant);
                System.out.println("Datos de participante " + dateParticipant.getFirstName() + " "
                        + dateParticipant.getLastName() + " numero de inscripcion: "
                        + lInscriptions.get(i).numInscription);
            }

        }

        // Numeral E
        int inscriptionToRemove = 0;
        lInscriptions.remove(inscriptionToRemove);
        for (Inscription singleInscription : lInscriptions) {
            System.out.println("Lista inscritos : " + singleInscription.numInscription + " " +
                    singleInscription.category.getNameCategory() + " "
                    + singleInscription.participant.getFirstName() + " " + singleInscription.participant.getLastName()
                    + " monto a pagar " + singleInscription.getAmount() + " edad "
                    + singleInscription.participant.getAge());

        }

        // Numeral F

        double amountCategoryShort = 0;
        double amountCategoryMedium = 0;
        double amountCategoryAdvance = 0;

        for (Inscription singleInscription : lInscriptions) {
            switch (singleInscription.category.idCategory) {
                case 0:
                default:
                    amountCategoryShort += singleInscription.getAmount();
                    break;
                case 1:
                    amountCategoryMedium += singleInscription.getAmount();
                    break;
                case 2:
                    amountCategoryAdvance += singleInscription.getAmount();
                    break;

            }

        }
        System.out
                .println("El total de la categoria " + shortCategory.getNameCategory() + " es :" + amountCategoryShort);
        System.out.println(
                "El total de la categoria " + mediumCategory.getNameCategory() + " es :" + amountCategoryMedium);
        System.out.println(
                "El total de la categoria " + avancedCategory.getNameCategory() + " es :" + amountCategoryAdvance);
        System.out.println("El total de monto recaudado entre las categorias es: "
                + (amountCategoryShort + amountCategoryMedium + amountCategoryAdvance));
    }

}
