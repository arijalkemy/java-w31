import Model.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        Cliente cliente = new Cliente("1faaFDAGRhtds543");

        List<Reserva> reservas = List.of(
                new Reserva(TipoReserva.HOTEL, 1000),
                new Reserva(TipoReserva.COMIDA, 1000),
                new Reserva(TipoReserva.BOLETO, 1000),
                new Reserva(TipoReserva.TRANSPORTE, 1000)
        );

        Localizador localizador = new Localizador(cliente, reservas);
        cliente.addLocalizador(localizador);
        // repositorioCliente.

        /*


Por tanto los descuentos se aplicarán cuando:

Si un cliente anteriormente adquirió al menos 2 localizadores, se le descontará un 5% del total para futuras compras.
Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida, boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
Al momento de generar el localizador se debe almacenar en una clase repositorio y se imprimirá el mismo con los detalles de la compra.

Se requiere crear un repositorio cliente, para así poder buscar las reservas anteriores del cliente y aplicar descuentos; en caso de no existir el cliente poder agregarlo al repositorio cliente.


Parte I

Presentar un escenario donde:

Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior, almacenar e imprimir el resultado.
Crear un localizador con una sola reserva para el mismo cliente.
Verificar que los descuentos fueron aplicados.


Parte II (Opcional)

Agregar una clase que permita realizar las siguientes consultas sobre los localizadores vendidos, empleando diferentes métodos que muestren:


Cantidad de localizadores vendidos.
Cantidad total de reservas.
Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).
Total de ventas.
Promedio de todas las ventas.

         */
    }
}