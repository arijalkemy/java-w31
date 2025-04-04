package clase.POO.integrador1.agenciaturismo;

import clase.POO.integrador1.agenciaturismo.models.*;

import java.util.HashSet;
import java.util.Set;


    
public class Main {
    public static void main(String[] args) {
        // Crear clientes
        Cliente juan = new Cliente("Juan", "Pérez", "12345678", "1133334444", "juan@example.com");
        Cliente maria = new Cliente("María", "González", "87654321", "1144445555", "maria@example.com");

        // Crear reservas para Juan
        Reserva hotelA = new Reserva(1, "Hotel A", "2023-10-01", "2023-10-05", 100.0);
        Reserva transporteA = new Transporte(2, "Transporte A", "2023-10-01", "2023-10-05", 50.0, 2);
        Reserva comidaA = new Comida(3, "Comida A", "2023-10-01", "2023-10-05", 20.0, 2);
        Reserva viajeA = new Viajes(4, "Viaje A", "2023-10-01", "2023-10-05", 200.0, 2);

        // Crear reservas para María
        Reserva hotelB = new Hotel(5, "Hotel B", "2023-11-10", "2023-11-15", 150.0, 1);
        Reserva viajeB = new Viajes(6, "Viaje B", "2023-11-10", "2023-11-15", 250.0, 1);

        // Crear localizadores y asignar reservas
        Localizador localizadorJuan1 = new Localizador(1, juan);
        localizadorJuan1.agregarReserva(hotelA);
        localizadorJuan1.agregarReserva(transporteA);
        localizadorJuan1.agregarReserva(comidaA);
        localizadorJuan1.agregarReserva(viajeA);

        Localizador localizadorJuan2 = new Localizador(2, juan);
        localizadorJuan2.agregarReserva(hotelB);
        localizadorJuan2.agregarReserva(viajeB);

        Localizador localizadorMaria = new Localizador(3, maria);
        localizadorMaria.agregarReserva(hotelB);
        localizadorMaria.agregarReserva(viajeB);

        // Agregar localizadores a los clientes
        juan.agregarLocalizador(localizadorJuan1.getId());
        juan.agregarLocalizador(localizadorJuan2.getId());
        maria.agregarLocalizador(localizadorMaria.getId());

        // Emitir facturas
        Set<Localizador> localizadoresJuan = new HashSet<>();
        localizadoresJuan.add(localizadorJuan1);
        localizadoresJuan.add(localizadorJuan2);

        Set<Localizador> localizadoresMaria = new HashSet<>();
         localizadoresMaria.add(localizadorMaria);

        Factura facturaJuan = new Factura(1, juan, localizadoresJuan, "2023-12-01");
        Factura facturaMaria = new Factura(2, maria, localizadoresMaria, "2023-12-05");

        facturaJuan.emitirFactura();
        System.out.println();
        facturaMaria.emitirFactura();
    }
}
