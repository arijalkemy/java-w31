package ejercicio_dakar;

public class Main {
    public static void main(String[] args) {

        Carrera carrera = new Carrera(100.0, 2.0, "Monza", 4);

        carrera.darDeAltaAuto(1200, 2, 23, "AAA222");
        carrera.darDeAltaMoto(200, 2, 23, "AAA333");
        carrera.darDeAltaMoto(200, 20, 23, "AAA444");

        System.out.println(carrera.getListaDeVehiculos());


        System.out.println("--------");
        System.out.println(carrera.getGanador());
    }
}
