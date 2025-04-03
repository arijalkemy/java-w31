package modelos;

public class Cliente {
    private long dni;
    private String name;

    public Cliente(long dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
