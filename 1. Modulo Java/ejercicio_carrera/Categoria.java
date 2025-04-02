public class Categoria {
    public int id;
    public String nombre;
    public String descripcion;

    public Categoria(int id) {
        this.id = id;
        switch (id) {
            case 1:
                this.nombre = "Circuito chico";
                this.descripcion = "2 km por selva y arroyos";
                break;
            case 2:
                this.nombre = "Circuito medio";
                this.descripcion = "5 km por selva, arroyo y barro";
                break;
            case 3:
                this.nombre = "Circuito avanzado";
                this.descripcion = "10 km por selva, arroyos, barro y escalada en piedra";
                break;
        }
    }
}