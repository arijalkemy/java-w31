package clase.POO.integrador1.agenciaturismo.models;

import java.util.HashSet;
import java.util.Set;

public class Cliente {

    private final String nombre;
    private final String apellido;
    private final String dni;
    private final String telefono;
    private final String email;
    private final Set<Integer> localizadores;

    public Cliente(String nombre, String apellido, String dni, String telefono, String email) {
        this.nombre = validarString(nombre, "Nombre");
        this.apellido = validarString(apellido, "Apellido");
        this.dni = validarDni(dni);
        this.telefono = validarTelefono(telefono);
        this.email = validarEmail(email);
        this.localizadores = new HashSet<>();
    }

    // GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Set<Integer> getLocalizadores() {
        return new HashSet<>(localizadores); // Retorna una copia para evitar modificaciones externas
    }

    public int getCantidadLocalizadores() {
        return localizadores.size();
    }

    // MÉTODOS
    public void agregarLocalizador(int reserva) {
        if (reserva <= 0) {
            throw new IllegalArgumentException("El identificador de la reserva debe ser un número positivo.");
        }
        localizadores.add(reserva);
    }

    // VALIDACIONES
    private String validarString(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
        return valor.trim();
    }

    private String validarDni(String dni) {
        if (dni == null || !dni.matches("\\d{7,8}")) {
            throw new IllegalArgumentException("El DNI debe tener entre 7 y 8 dígitos.");
        }
        return dni;
    }

    private String validarTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{10,15}")) {
            throw new IllegalArgumentException("El teléfono debe contener entre 10 y 15 dígitos.");
        }
        return telefono;
    }

    private String validarEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            throw new IllegalArgumentException("Email no válido.");
        }
        return email;
    }

    @Override
    public String toString() {
        return "Cliente{"
                + "nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", dni='" + dni + '\''
                + ", telefono='" + telefono + '\''
                + ", email='" + email + '\''
                + ", cantidadLocalizadores=" + getCantidadLocalizadores()
                + '}';
    }
}
