package animals;

public class Cow extends Animal implements IHerbivore{
    public Cow(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Mooo");
    }

    @Override
    public void eatGrass() {
        System.out.println("Eating grass...");
    }
}
