package mascotas;

class Vaca extends Animal implements Herbivoro {

    @Override
    void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierba.");
    }
}
