import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.listaDeVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("No hay más cupo para autos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            System.out.println("No hay más cupo para motos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        listaDeVehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        listaDeVehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador() {
        Vehiculo ganador = null;
        double maxDesempeno = Double.NEGATIVE_INFINITY;
        for (Vehiculo v : listaDeVehiculos) {
            double desempeno = v.calcularDesempeno();
            if (desempeno > maxDesempeno) {
                maxDesempeno = desempeno;
                ganador = v;
            }
        }
        return ganador;
    }

    public void socorrerAuto(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v instanceof Auto && v.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) v);
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo v : listaDeVehiculos) {
            if (v instanceof Moto && v.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) v);
            }
        }
    }
}
