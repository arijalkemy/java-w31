package AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsultaLocalizadores {
    private List<Localizador> localizadores;

    public ConsultaLocalizadores() {
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    //cantidad localizadoes vendidos
    public int getCantidadLocalizadores() {
        return this.localizadores.size();
    }

    //cantidad total reservas
    public int getCantidadTotalReservas(){
        int totalReservas = 0;
        for(Localizador localizador : this.localizadores){
            totalReservas+= localizador.getReservas().size();
        }
        return totalReservas;
    }

    //diccionario de reservas por tipo
    public Map<String, Localizador> getReservasPorTipo() {
        Map<String, Localizador> reservasPorTipo = new HashMap<>();
        for(Localizador localizador : this.localizadores){
            for(Reserva reserva : localizador.getReservas()){
                reservasPorTipo.put(reserva.getTipo(), localizador);
            }
        }
        return reservasPorTipo;
    }

    //total ventas
    public double getTotalVentas(){
        double totalVentas = 0;
        for(Localizador localizador : this.localizadores){
            totalVentas+=localizador.calcularTotalConDescuentos();
        }
        return totalVentas;
    }

    //promedio ventas
    public double getPromedioVentas(){
        if(localizadores.isEmpty()){
            return 0;
        }
        return getTotalVentas()/getCantidadLocalizadores();
    }


}
