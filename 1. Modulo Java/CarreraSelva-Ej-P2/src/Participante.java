public class Participante {
    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private String celular;
    private String numeroEmergencia;
    private String grupoSanguineo;
    private Categoria catPedida;


    public Participante(int numeroParticipante, int dni, String nombre, String apellido,
                            int edad, String celular, String numeroEmergencia, String grupoSanguineo, Categoria catPedida) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.catPedida = catPedida;
    }


    public void mostrarDatos(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Dni: " + dni);
        System.out.println("Edad: " + edad);
        System.out.println("Cel: " + celular);
        System.out.println("GrupoSan: " + grupoSanguineo);

    }

    public int getEdad() {
        return edad;
    }

    public Categoria getCatPedida(){
        return  catPedida;
    }

    public int getNumeroParticipante(){
        return  numeroParticipante;
    }
}
