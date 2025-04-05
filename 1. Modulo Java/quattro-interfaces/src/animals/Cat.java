package animals;

public class Cat extends Animal implements ICarnivore {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public void eatMeat() {
        System.out.println("Eating meat...");
    }
}
