package bootcamp.integrador_tarde.dakar;

public class SocorristaMoto implements Socorristas<Moto>{

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto: " + vehiculo.getPatente());
    }
}
