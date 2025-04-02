package clase.estructura.datos.dos;

import java.util.ArrayList;
import java.util.List;

public class Inscription {

    private List<Participant> participantes;

    public Inscription() {
        this.participantes = new ArrayList<>();
    }

    public void addParticipante(Participant participante) {
        participantes.add(participante);
    }

    public void removeParticipante(int id) {
        participantes.removeIf(p -> p.getId() == id);
    }

    public void mostrarInscritos() {
        if (participantes.isEmpty()) {
            System.out.println("No hay participantes inscritos.");
        } else {
            System.out.println("Participantes inscritos:");
            for (Participant p : participantes) {
                System.out.println(p);
            }
        }
    }

    public void getPrices() {
        int totalRecaudoChico = 0;
        int totalRecaudoMedio = 0;
        int totalRecaudoAvanzado = 0;

        for (Participant p : participantes) {
            if (p.getCategoria().equals("chico")){
                totalRecaudoChico += p.getPrecio();
            }
            if (p.getCategoria().equals("medio")){
                totalRecaudoMedio += p.getPrecio();
            }
            if (p.getCategoria().equals("avanzado")){
                totalRecaudoAvanzado += p.getPrecio();
            }
        }
        System.out.println("Total recaudo Chico: " + totalRecaudoChico + "\nTotal recaudo Medio: " + totalRecaudoMedio + "\nTotal recaudo Avanzado: " + totalRecaudoAvanzado);
    }
}