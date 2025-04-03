package banco;

import java.math.BigDecimal;

import banco.clientes.Cliente;
import banco.clientes.ClienteBasico;
import banco.clientes.ClienteEjecutivo;

public class Banco {

    public static void main(String[] args) {
        // Crear clientes
        ClienteEjecutivo clienteEjecutivo = new ClienteEjecutivo("Juan Pérez", 35, new BigDecimal("10000"));
        ClienteBasico clienteBasico = new ClienteBasico("Ana García", 28, new BigDecimal("5000"));

        // Mostrar saldo inicial
        mostrarSaldoInicial(clienteEjecutivo);
        mostrarSaldoInicial(clienteBasico);

        // Operaciones del Cliente Ejecutivo
        System.out.println("\n### Operaciones del Cliente Ejecutivo ###");
        ClienteBasico clienteDestino = new ClienteBasico("Carlos Sánchez", 40, new BigDecimal("2000"));
        hacerDeposito(clienteEjecutivo, new BigDecimal("2000"));
        hacerTransferencia(clienteEjecutivo, new BigDecimal("1500"), clienteDestino);

        // Operaciones del Cliente Básico
        System.out.println("\n### Operaciones del Cliente Básico ###");
        consultarSaldo(clienteBasico);
        pagarServicio(clienteBasico, new BigDecimal("300"), "Electricidad");
        retirarEfectivo(clienteBasico, new BigDecimal("1000"));

        // Mostrar saldo final
        mostrarSaldoFinal(clienteEjecutivo);
        mostrarSaldoFinal(clienteBasico);
    }

    // Métodos auxiliares para mejorar los logs

    private static void mostrarSaldoInicial(Cliente cliente) {
        System.out.println("Saldo inicial de " + cliente.getClass().getSimpleName() + " (" + cliente.getNombreCompleto() + "): $" + cliente.getSaldo());
    }

    private static void mostrarSaldoFinal(Cliente cliente) {
        System.out.println("Saldo final de " + cliente.getClass().getSimpleName() + " (" + cliente.getNombreCompleto() + "): $" + cliente.getSaldo());
    }

    private static void hacerDeposito(ClienteEjecutivo clienteEjecutivo, BigDecimal monto) {
        System.out.println("Realizando depósito de: $" + monto);
        clienteEjecutivo.hacerDeposito(monto);
    }

    private static void hacerTransferencia(ClienteEjecutivo clienteEjecutivo, BigDecimal monto, ClienteBasico clienteDestino) {
        System.out.println("Realizando transferencia de: $" + monto + " a " + clienteDestino.getNombreCompleto());
        clienteEjecutivo.hacerTransferencia(monto, clienteDestino);
    }

    private static void consultarSaldo(ClienteBasico clienteBasico) {
        System.out.println("Consultando saldo de " + clienteBasico.getNombreCompleto());
        clienteBasico.consultarSaldo();
    }

    private static void pagarServicio(ClienteBasico clienteBasico, BigDecimal monto, String servicio) {
        System.out.println("Pagando servicio de: $" + monto + " para " + servicio);
        clienteBasico.pagarServicio(monto, servicio);
    }

    private static void retirarEfectivo(ClienteBasico clienteBasico, BigDecimal monto) {
        System.out.println("Retirando efectivo de: $" + monto);
        clienteBasico.retirarEfectivo(monto);
    }
}
