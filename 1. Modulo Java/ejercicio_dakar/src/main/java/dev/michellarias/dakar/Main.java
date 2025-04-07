package dev.michellarias.dakar;

public class Main {
    public static void main(String[] args) {

        Carrera carreraDakar = new Carrera(
                100D,
                5000D,
                "Carrera del Desierto",
                4);

        SocorristaMoto socorristaMoto = new SocorristaMoto(
                80D,
                60D,
                50D,
                "MOTSOCOR");

        SocorristaAuto socorristaAuto = new SocorristaAuto(
                90D,
                70D,
                50D,
                "AUTSOCOR");

        carreraDakar.darDeAltaAuto(100D, 40D, 30D, "BMW");
        carreraDakar.darDeAltaMoto(180D, 20D, 10D, "HONDA");

        carreraDakar.setSocorristaAuto(socorristaAuto);
        carreraDakar.setSocorristaMoto(socorristaMoto);

        carreraDakar.socorrerAuto("BMW");
        carreraDakar.calcularGanador();
    }
}
