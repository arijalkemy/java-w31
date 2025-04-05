package documents;

import java.util.List;

public class Curriculum implements IDocument, IPrintable {
    private String author;
    private List<String> skills;
    private List<String> experience;

    public Curriculum(String author, List<String> skills, List<String> experience) {
        this.author = author;
        this.skills = skills;
        this.experience = experience;
    }

    @Override
    public void print() {
        System.out.println("\nPrinting curriculum...\n");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return author + "'s Curriculum" +
                "\nSkills= " + String.join(", ", skills) +
                "\nExperience= " + String.join(", ", experience);
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public void setExperience(List<String> experience) {
        this.experience = experience;
    }

    public List<String> getSkills() {
        return skills;
    }

    public List<String> getExperience() {
        return experience;
    }

    @Override
    public String getAuthor() {
        return author;
    }
}
