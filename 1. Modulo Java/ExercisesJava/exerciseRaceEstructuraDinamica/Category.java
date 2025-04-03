package exerciseRaceEstructuraDinamica;

public class Category {
    public int idCategory;
    private String nameCategory;
    public String description;

    public Category(int idCategory, String nameString, String description) {
        this.idCategory = idCategory;
        this.nameCategory = nameString;
        this.description = description;
    }

    public String getNameCategory() {
        return this.nameCategory;
    }
    
}
