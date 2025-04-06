package Practica7;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("12", "Pedro");
        Repositorio repo = new Repositorio();

        Localizador localizador = new Localizador(cliente);// o.O???

        Reserva reservaHotelUno = new Reserva("111", TipoReserva.HOTEL , 200);
        Reserva reservaHotelDos = new Reserva("102", TipoReserva.HOTEL , 200);
        Reserva reserva = new Reserva("111", TipoReserva.HOTEL , 200);
        Reserva reservados = new Reserva("102", TipoReserva.HOTEL , 200);

        localizador.agregarReserva(new Reserva("111", TipoReserva.HOTEL , 200));
        localizador.agregarReserva(new Reserva("112", TipoReserva.HOTEL , 200));
        localizador.agregarReserva(new Reserva("113", TipoReserva.AVION , 400));
        localizador.agregarReserva(new Reserva("114", TipoReserva.AVION , 400));

        repo.registrarLocalizador(cliente, localizador);

        String informe = repo.mostrarRepositorio();
        System.out.println(informe);


        Localizador localizadorDos = new Localizador(cliente);// o.O???
        localizadorDos.agregarReserva(new Reserva("115", TipoReserva.HOTEL , 200));
        repo.registrarLocalizador(cliente, localizadorDos);
        informe = repo.mostrarRepositorio();
        System.out.println(informe);
    }
}
