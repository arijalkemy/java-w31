package exerciseIntegrador1.clases;

public class Cliente {
    private String dni;
    private String nombreCliente;
    private Integer edad;

    public Cliente(String dni, String nombreCliente, Integer edad) {
        this.dni = dni;
        this.nombreCliente = nombreCliente;
        this.edad = edad;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

}
