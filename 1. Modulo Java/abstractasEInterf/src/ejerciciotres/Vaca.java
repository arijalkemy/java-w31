package ejerciciotres;

public class Vaca extends Animal implements Hervivoro{
    public Vaca(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!!");
    }

    @Override
    public String comer() {
        return "Soy una vaca y estoy comiendo hierva";
    }
}
