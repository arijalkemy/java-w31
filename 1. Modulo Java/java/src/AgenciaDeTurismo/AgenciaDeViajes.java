package AgenciaDeTurismo;

public class AgenciaDeViajes {
    public static void main(String[] args){
        //crear repo clientes
        RepositorioCliente rep = new RepositorioCliente();

        //crear cliente y agregar al repo
        Cliente cliente1=new Cliente("Manuela Tonelli","42538617");
        rep.adicionaCliente(cliente1);

        ConsultaLocalizadores consulta = new ConsultaLocalizadores();

        //crear localizador paquete completo
        Localizador paqueteCompleto = new Localizador(cliente1);
        paqueteCompleto.agregaReserva(new Reserva("hotel",100));
        paqueteCompleto.agregaReserva(new Reserva("comida",50));
        paqueteCompleto.agregaReserva(new Reserva("boleto",200));
        paqueteCompleto.agregaReserva(new Reserva("transporte",10));
        rep.incrementarLocalizadores(cliente1);
        consulta.agregarLocalizador(paqueteCompleto);

        System.out.println("Cliente contrata paquete completo: ");
        System.out.println(paqueteCompleto);
        System.out.println("------------------------------------------------");

        // crear localizador con 2 reservas de hotel y 2 de boletos
        Localizador reservasDobles = new Localizador(cliente1);
        reservasDobles.agregaReserva(new Reserva("hotel",100));
        reservasDobles.agregaReserva(new Reserva("hotel",300));
        reservasDobles.agregaReserva(new Reserva("boleto",100));
        reservasDobles.agregaReserva(new Reserva("boleto",50));
        rep.incrementarLocalizadores(cliente1);
        consulta.agregarLocalizador(paqueteCompleto);

        System.out.println("Cliente contrata reservas dobles \n" + reservasDobles);
        System.out.println("------------------------------------------------");

        // crear localizador con una sola reserva
        Localizador reservaSimple = new Localizador(cliente1);
        reservaSimple.agregaReserva(new Reserva("transporte",100));
        rep.incrementarLocalizadores(cliente1);
        consulta.agregarLocalizador(paqueteCompleto);

        System.out.println("Cliente contrata reserva simple \n" + reservaSimple);
        System.out.println("------------------------------------------------");

        //ejercicio adicional
        System.out.println("\nConsulta de Localizadores");
        System.out.println("Cantidad de localizadores vendidos: " + consulta.getCantidadLocalizadores());
        System.out.println("Cantidad total de reservas: " + consulta.getCantidadTotalReservas());
        System.out.println("Reservas clasificadas por tipo: " + consulta.getReservasPorTipo());
        System.out.println("Total de ventas: $" + consulta.getTotalVentas());
        System.out.println("Promedio de ventas: $" + consulta.getPromedioVentas());
    }
}
