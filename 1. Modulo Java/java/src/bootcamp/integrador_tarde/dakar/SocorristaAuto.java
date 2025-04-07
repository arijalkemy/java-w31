package bootcamp.integrador_tarde.dakar;

public class SocorristaAuto implements Socorristas<Auto>{
    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto: " + vehiculo.getPatente());
    }
}
