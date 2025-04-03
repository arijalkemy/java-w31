package main.java;



import java.util.ArrayList;

    public class Categoria {
        private String nombre;
        private String descripcion;
        private int precioMenor18;
        private int precioMayor18;
        private ArrayList<Inscripto> inscriptos;

        public Categoria(String nombre, String descripcion, int precioMenor18, int precioMayor18) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precioMenor18 = precioMenor18;
            this.precioMayor18 = precioMayor18;
            this.inscriptos = new ArrayList<>();
        }

        public String getNombre() {
            return nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public int getPrecioMenor18() {
            return precioMenor18;
        }

        public int getPrecioMayor18() {
            return precioMayor18;
        }

        public ArrayList<Inscripto> getInscriptos() {
            return inscriptos;
        }

        public void agregarInscripto(Inscripto inscripto) {
            inscriptos.add(inscripto);
        }

        public int calcularTotalRecaudado() {
            int total = 0;
            for (Inscripto inscripto : inscriptos) {
                total += inscripto.getMonto();
            }
            return total;
        };};

