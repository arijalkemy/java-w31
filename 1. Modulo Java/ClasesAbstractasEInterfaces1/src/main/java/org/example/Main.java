package org.example;
import org.example.models.Basico;
import org.example.models.Cliente;
import org.example.models.Cobrador;
import org.example.models.Ejecutivo;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo("Juan","Duran");
        Cobrador cobrador = new Cobrador("Jose","Peña");
        Basico basico = new Basico("Carlos","Charry");

        ejecutivo.deposito();
        ejecutivo.transferencia();

        basico.consultaSaldo();
        basico.pagoServicios();
        basico.retiroEfectivo();

        cobrador.consultaSaldo();
        cobrador.retiroEfectivo();

        List<Cliente> clientes = Arrays.asList(ejecutivo, cobrador, basico);

        clientes.forEach(cliente -> {
            System.out.println("Nombre: "+ cliente.getNombre()+" "+ cliente.getApellido());
            cliente.transaccionOk();
            cliente.transaccionNoOk();
        });

    }
}