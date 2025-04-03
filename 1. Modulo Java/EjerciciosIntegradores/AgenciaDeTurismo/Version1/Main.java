package EjerciciosIntegradores.AgenciaDeTurismo.Version1;

import java.util.List;

/*
 * Una agencia de viajes premia a sus viajeros con descuentos cuando desean adquirir
 * algún paquete turístico, el cual consiste en reservas de hotel, comida, boletos
 * de viajes y transporte. Las reservas son almacenadas en localizadores, los cuales
 * contienen los datos del cliente, el total y la reserva o varias reservas
 * dependiendo del producto adquirido. Por tanto los descuentos se aplicarán cuando:
 *  - Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará
 *    un 5% del total para futuras compras.
 *  - Si un cliente adquiere un paquete completo que consiste en reserva de hotel,
 *    comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de
 *    la factura.
 *  - Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un
 *    descuento de 5% en esas reservas.
 *  - Al momento de generar el localizador se debe almacenar en una clase repositorio
 *    y se imprimirá el mismo con los detalles de la compra.
 * Se requiere crear un repositorio cliente, para así poder buscar las reservas
 * anteriores del cliente y aplicar descuentos; en caso de no existir el cliente poder
 * agregarlo al repositorio cliente.
 * 
 * Parte I 
 * Presentar un escenario donde:
 *  - Crear un localizador con un paquete completo para un cliente, almacenar e imprimir
 *    el resultado. 
 *  - Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente
 *    anterior, almacenar e imprimir el resultado.
 *  - Crear un localizador con una sola reserva para el mismo cliente.
 *  - Verificar que los descuentos fueron aplicados.
 * 
 * Parte II (Opcional)
 * Agregar una clase que permita realizar las siguientes consultas sobre los
 * localizadores vendidos, empleando diferentes métodos que muestren:
 *  - Cantidad de localizadores vendidos.
 *  - Cantidad total de reservas.
 *  - Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,
 *    comida,transporte).
 *  - Total de ventas.
 *  - Promedio de todas las ventas.
 */
public class Main {
    public static void main(String[] args) {
        //Parte I
        Repositorio localizadoresRepository = new Repositorio();
        
        //Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado
        Cliente client = new Cliente("Carlos", "Ramirez", "1234");
        Reserva reservaHotel = new Reserva(1000.0, TipoReserva.HOTEL);
        Reserva reservaVuelo = new Reserva(500.0, TipoReserva.VUELO);
        Reserva reservaComida = new Reserva(200.0, TipoReserva.COMIDA);
        Reserva reservaTransporte = new Reserva(100.0, TipoReserva.TRANSPORTE);
        
        List<Reserva> reservasCarlos = List.of(reservaHotel, reservaVuelo, reservaComida, reservaTransporte);
        Localizador localizadoraCarlos1 = new Localizador(client, reservasCarlos);
        localizadoresRepository.storeLocalizador(localizadoraCarlos1);
        System.out.println("Precio total primera reserva: " + localizadoraCarlos1.getPrecioTotal());

        //Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
        Reserva segundaReservaHotel1 = new Reserva(700.0, TipoReserva.HOTEL);
        Reserva segundaReservaHotel2 = new Reserva(800.0, TipoReserva.HOTEL);
        Reserva segundaReservaVuelo1 = new Reserva(600.0, TipoReserva.VUELO);
        Reserva segundaReservaVuelo2 = new Reserva(400.0, TipoReserva.VUELO);

        List<Reserva> segundaReservaCarlos = List.of(segundaReservaHotel1, segundaReservaHotel2, segundaReservaVuelo1, segundaReservaVuelo2);
        Localizador localizadoraCarlos2 = new Localizador(client, segundaReservaCarlos);
        localizadoresRepository.storeLocalizador(localizadoraCarlos2);
        System.out.println("Precio total segunda reserva: " + localizadoraCarlos2.getPrecioTotal());

        // Crear un localizador con una sola reserva para el mismo cliente.
        Reserva terceraReservaHotel = new Reserva(1000., TipoReserva.HOTEL);
        List<Reserva> terceraReservaCarlos = List.of(terceraReservaHotel);
        Localizador localizadoraCarlos3 = new Localizador(client, terceraReservaCarlos);
        localizadoresRepository.storeLocalizador(localizadoraCarlos3);
        System.out.println("Precio total tercera reserva: " + localizadoraCarlos3.getPrecioTotal());
    }
}
