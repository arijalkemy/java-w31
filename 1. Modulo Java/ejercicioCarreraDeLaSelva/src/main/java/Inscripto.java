package main.java;

    public class Inscripto {
        private String dni;
        private String nombre;
        private String apellido;
        private int edad;
        private String celular;
        private String emergencia;
        private String grupo;
        private int monto;

        public Inscripto(String dni, String nombre, String apellido, int edad, String celular, String emergencia, String grupo, int monto) {
            this.dni = dni;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
            this.celular = celular;
            this.emergencia = emergencia;
            this.grupo = grupo;
            this.monto = monto;
        };

        public int getMonto() {
            return monto;
        };

        public String toString() {
            return String.format("DNI: %s, Nombre: %s, Apellido: %s, Edad: %d, Celular: %s, Emergencia: %s, Grupo: %s, Monto: $%d",
                    dni, nombre, apellido, edad, celular, emergencia, grupo, monto);
        }
    };


