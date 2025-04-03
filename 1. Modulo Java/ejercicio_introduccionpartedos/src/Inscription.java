import java.util.Map;

public class Inscription {
    private static int id_generated;
    private final int id;
    private Category category;
    private Participant participant;
    private double price;

    public Inscription(Category category, Participant participant) {
        this.category = category;
        this.participant = participant;
        this.setPrice();
        this.id = ++id_generated;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        this.price = category.getPriceRules().entrySet()
                .stream()
                .filter(entry -> entry.getKey().test(participant.getAge()))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No price defined for age: " + participant.getAge()));
    }
}