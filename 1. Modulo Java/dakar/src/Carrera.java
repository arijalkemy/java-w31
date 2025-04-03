import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premio, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premio;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        vehiculos = new ArrayList<Vehiculo>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() >= cantidadDeVehiculosPermitidos) {
            System.out.println("El cupo de la carrera está completo");
        }
        else {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }
    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() >= cantidadDeVehiculosPermitidos) {
            System.out.println("El cupo de la carrera está completo");
        }
        else {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public Optional<Vehiculo> buscarVehiculo(String unaPatente) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(unaPatente))
                .findFirst();
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }
    public void eliminarVehiculo(String unaPatente) {
        Optional<Vehiculo> resultado = buscarVehiculo(unaPatente);
        if (resultado.isPresent()) {
            vehiculos.remove(resultado.get());
        }
        else {
            System.out.println("El vehiculo no existe");
        }
    }

    public void ganador() {
        Optional<Vehiculo> vehiculoGanador = vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getValorParaGanar));

        if (vehiculoGanador.isPresent()) {
            System.out.println("El vehiculo ganador es: " + vehiculoGanador.get().getPatente());
        }
        else {
            System.out.println("El vehiculo ganador no existe");
        }
    }

    public void socorrerVehiculo(String unaPatente) {
        Optional<Vehiculo> resultado = buscarVehiculo(unaPatente);
        if (resultado.isPresent()) {
            Vehiculo vehiculoEncontrado = resultado.get();
            if (vehiculoEncontrado instanceof Auto) {
                socorristaAuto.socorrer((Auto) vehiculoEncontrado);
            }
            else {
                socorristaMoto.socorrer((Moto) vehiculoEncontrado);
            }
        }
        else {
            System.out.println("El vehiculo no existe");
        }
    }
}
