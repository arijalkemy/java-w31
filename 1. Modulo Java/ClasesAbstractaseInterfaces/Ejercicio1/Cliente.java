package ClasesAbstractaseInterfaces.P1.Ejercicio1;

public abstract class Cliente {
    private String nombre;
    private String apellido;
    private int idCliente;
    private static int contadorClientes = 0;
    private double dineroEnCuenta;

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.idCliente = ++contadorClientes;
        this.dineroEnCuenta = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getId() {
        return this.idCliente;
    }
    public double getDineroEnCuenta() {
        return dineroEnCuenta;
    }
    public void setDineroEnCuenta(double dineroEnCuenta) {
        this.dineroEnCuenta = dineroEnCuenta;
    }
    
}