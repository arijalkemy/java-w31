import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculoList = new ArrayList<>();
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(Double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion,Double anguloDeGiro, String patente){
        if(vehiculoList.size() < cantidadDeVehiculosPermitidos){
            vehiculoList.add(new Auto(velocidad,aceleracion,anguloDeGiro, patente, 1000.0, 4));
            System.out.println("Auto agregado correctamente.");
        }else {
            System.out.println("No hay cupos disponibles.");
        }
    }
    public void darDeAltaMoto(Double velocidad, Double aceleracion,Double anguloDeGiro, String patente){
        if(vehiculoList.size() < cantidadDeVehiculosPermitidos){
            vehiculoList.add(new Moto(velocidad,aceleracion,anguloDeGiro, patente, 300.0, 2));
            System.out.println("Moto agregada correctamente.");
        }else {
            System.out.println("No hay cupos disponibles.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        if(vehiculoList.contains(vehículo)){
            vehiculoList.remove(vehículo);
            System.out.println("Vehiculo eliminaso correctamente.");
        }else {
            System.out.println("El vehiculo no se encuentra en la lista.");
        }

    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculoList.stream()
                .filter(v -> v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> vehiculoList.remove(v));
        System.out.println("Vehiculo con patente " + patente + " eliminado correctamente.");
    }

    public Vehiculo ganador() {
        return vehiculoList.stream()
                .max((v1, v2) -> {
                    double valor1 = v1.getVelocidad() * 0.5 * v1.getAceleracion() / (v1.getAnguloDeGiro() * (v1.getPeso() - v1.getRuedas() * 100));
                    double valor2 = v2.getVelocidad() * 0.5 * v2.getAceleracion() / (v2.getAnguloDeGiro() * (v2.getPeso() - v2.getRuedas() * 100));
                    return Double.compare(valor1, valor2);
                })
                .orElse(null);
    }

    public void socorrerAuto(String patente){
        for (Vehiculo v : vehiculoList){
            if(v instanceof Auto && v.getPatente().equalsIgnoreCase(patente)){
                socorristaAuto.socorrer((Auto) v);
                return;
            }
        }
        System.out.println("Auto con patente " + patente + " no encontrado.");
    }

    public void socorrerMoto(String patente){
        for (Vehiculo v : vehiculoList){
            if(v instanceof Moto && v.getPatente().equalsIgnoreCase(patente)){
                socorristaMoto.socorrer((Moto) v);
                return;
            }
        }
        System.out.println("Moto con patente " + patente + " no encontrada.");
    }


    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculoList=" + vehiculoList +
                ", socorristaAuto=" + socorristaAuto +
                ", socorristaMoto=" + socorristaMoto +
                '}';
    }
}
