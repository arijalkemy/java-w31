package clasesagencia;

import java.util.HashMap;
import java.util.List;

public class Repositorio {
    private List<Localizador> localizadores;

    public Repositorio(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void addLocalizador (Localizador localizador){
        localizadores.add(localizador);
    }

    public void mostrarLocalizadores (){
        this.calcularDescuentos();
        for (Localizador localizador : localizadores) {
            localizador.mostrarLocalizador();
            System.out.println();
        }
    }

    public void calcularDescuentos(){
        Cliente cliente = localizadores.getFirst().getCliente();
        // Asumo que el descuento no es acumulativo
        if(localizadores.size() >= 2) {
            cliente.setDescuento(0.05);
            for (Localizador localizador : localizadores) {
                HashMap<String, Integer> tiposReservas = localizador.getTiposReservas();
                Integer conteoHotel = tiposReservas.get("Hotel");
                Integer conteoBoleto = tiposReservas.get("Boleto");
                if (conteoHotel == null) {
                    conteoHotel = 0;
                }if (conteoBoleto == null) {
                    conteoBoleto = 0;
                }
                if(conteoBoleto == 2 || conteoHotel == 2) {
                    cliente.setDescuento(0.05);
                }
            }
        }
        for (Localizador localizador : localizadores) {
            if(localizador.getEsPaqueteCompleto()) {
                cliente.setDescuento(0.1);
            }
        }
    }

    public Integer cantidadLocalizadores(){ return localizadores.size(); }

    public Integer cantidadReservas(){
        Integer cantidad = 0;
        for (Localizador localizador : localizadores) {
            cantidad += localizador.getReservas().size();
        }
        return cantidad;
    }

    public Double totalVentas() {
        Double total = 0.0;
        for (Localizador localizador : localizadores) {
            total += localizador.getTotal();
        }
        return total;
    }
}
