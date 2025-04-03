package EJINT_AgenciaDeTurismo;

public class Cliente {
    private String nombre;
    private String dni;
    private int localizadoresC;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.localizadoresC = 0;
    }

    public String getDni() {
        return dni;
    }

    public int getLocalizadoresC() {
        return localizadoresC;
    }

    public void incrementarLocalizadoresC() {
        this.localizadoresC++;
    }

    @Override public String toString() {
    return "Cliente{" +
            "nombre='" + nombre + '\'' +
            ", dni='" + dni + '\'' +
            '}';
    }
}

