package animals;

public class Dog extends Animal implements ICarnivore {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof");
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating meat...");
    }
}
