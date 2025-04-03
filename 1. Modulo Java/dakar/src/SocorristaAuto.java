public class SocorristaAuto implements Socorrista<Auto> {

    public void socorrer(Auto auto) {
        System.out.println("Socorriendo moto " + auto.getPatente());
    }
}
