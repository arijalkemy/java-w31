package ABSeINT_Imprimible;
import java.util.List;
public class Curriculum implements Imprimible {
        private String nombre;
        private String apellido;
        private String direccion;
        private String telefono;
        private List<String> habilidades;

        public Curriculum(String nombre, String apellido, String direccion, String telefono, List<String> habilidades) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.direccion = direccion;
            this.telefono = telefono;
            this.habilidades = habilidades;
        }

        @Override
        public void imprimir() {
            System.out.println("Curriculum:");
            System.out.println("Nombre: " + nombre + " " + apellido);
            System.out.println("Dirección: " + direccion);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Habilidades: " + habilidades);
            System.out.println();
        }
    }

