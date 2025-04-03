import java.util.Map;
import java.util.function.Predicate;

public class Category {
    private static int id_generated;
    private final int id;
    private String name;
    private String description;
    private Map<Predicate<Integer>, Double> priceRules;

    public Category(String name, String description, Map<Predicate<Integer>, Double> agePrice) {
        this.id = ++id_generated;
        this.name = name;
        this.description = description;
        this.priceRules = agePrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<Predicate<Integer>, Double> getPriceRules() {
        return priceRules;
    }

    public void setPriceRules(Map<Predicate<Integer>, Double> priceRules) {
        this.priceRules = priceRules;
    }
}