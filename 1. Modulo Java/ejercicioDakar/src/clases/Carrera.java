package clases;

import java.util.List;

public class Carrera{
    private Double distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto autoSocorrista;
    private SocorristaMoto motoSocorrista;

    public Carrera(Double distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos,
                   SocorristaAuto autoSocorrista, SocorristaMoto motoSocorrista) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.autoSocorrista = autoSocorrista;
        this.motoSocorrista = motoSocorrista;
    }


    public void darDeAltaAuto(Integer velocidad,Integer aceleracion, Integer anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto nuevoAuto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(nuevoAuto);
        }else {
            System.out.println("Ya no hay cupo");
        }
    }

    public void darDeAltaMoto(Integer velocidad,Integer aceleracion, Integer anguloDeGiro, String patente){
        if(vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto nuevaMoto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(nuevaMoto);
        }else {
            System.out.println("Ya no hay cupo");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo){
        vehiculos.remove(vehículo);

    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getPatente() == unaPatente){
                vehiculos.remove(vehiculo);
            }
        }
    }

    public Vehiculo ganador(){
        Vehiculo vehiculoGanador = null;
        Double maximo = 0.0;
        for (Vehiculo vehiculo : vehiculos) {
            Double maximoAux = 0.0;
            maximoAux = (vehiculo.getVelocidad() * (0.5*vehiculo.getAceleracion())) /
                                    (vehiculo.getAnguloGiro()*(vehiculo.getPeso()-(vehiculo.getRuedas()-100)));
            if(maximo < maximoAux){
                maximo = maximoAux;
                vehiculoGanador = vehiculo;
            }
        }
        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getPatente() == patente) {
                autoSocorrista.socorrer((Auto) vehiculo);
            }
        }
    }

    public void socorrerMoto(String patente){
        for (Vehiculo vehiculo : vehiculos) {
            if(vehiculo.getPatente() == patente) {
                motoSocorrista.socorrer((Moto) vehiculo);
            }
        }
    }
}
