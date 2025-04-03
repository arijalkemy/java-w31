import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Inscripcion {
    Set<Inscripto> inscriptos;

    public Inscripcion(){
        inscriptos = new HashSet<Inscripto>();
    }

    private Inscripto crearInscripcion(Persona persona, Circuito circuito){
        Random randomizer = new Random();
        int numrandom = randomizer.nextInt(0, 20000);
        return new Inscripto(numrandom, persona, circuito);
    }
    private boolean estaInscripto(int dni){
        return this.inscriptos.stream().anyMatch(p -> p.persona.dni == dni);
    }
    private boolean esvalido(Persona persona, Circuito circuito){
        return persona.edad > circuito.edadMinima() && !estaInscripto(persona.dni);
    }

    public void inscribir(Persona persona, Circuito circuito){
        Inscripto toAdd;
        do {
            toAdd = this.crearInscripcion(persona, circuito);
        } while (this.inscriptos.contains(toAdd));

        if(this.esvalido(persona, circuito)) {
            this.inscriptos.add(toAdd);
            System.out.println("Inscripto correctamente: " + persona.nombre + " " + persona.apellido +
                    " Numero de inscripcion: " + toAdd.numero);
        }
        else {
            System.out.println("No fue posible inscribir a " + persona.nombre);
        }
    }

    public void desinscribir(int dni) {
        if(this.estaInscripto(dni)) {
            this.inscriptos.remove(inscriptos.stream().filter(a -> a.persona.dni == dni).findFirst().get());
            System.out.println("Eliminado");
        }
        else {
            System.out.println("Esa persona no esta inscripta");
        }
    }




    public void inscriptosDeCircuito(Circuito circuito){
        this.inscriptos.stream().filter(ins -> ins.circuito.getClass().equals(circuito.getClass())).forEach(elem ->{
                System.out.println("Nombre: " +elem.persona.nombre + " " + elem.persona.apellido);
                System.out.println("Numero inscripcion: " + elem.numero);
        });
    }

    public void inscriptos(){
        this.inscriptos.stream().forEach(elem ->{
            System.out.println("------------------------------------");
            System.out.println("Nombre: " +elem.persona.nombre + " " + elem.persona.apellido);
            System.out.println("Numero inscripcion: " + elem.numero);
            System.out.println("Costo: " + elem.precioApagar());
            System.out.println("------------------------------------");
        });
    }

    public int montoTotalPorCategoria(Circuito circuito){
        return this.inscriptos.stream().filter(ins -> ins.circuito.getClass().equals(circuito.getClass())).mapToInt(Inscripto::precioApagar).sum();
    }

    public int montoTotalDeTodasLasCategorias(){
        return this.inscriptos.stream().mapToInt(ins -> ins.precioApagar()).sum();
    }
}
