import java.util.*;

public class Main {

    public static void generarListasInscripciones(List<Inscripcion> listChico, Set<Participante> setParticipantes,
                                                  List<Inscripcion> listMedio, List<Inscripcion> listAvanzado,
                                                  Categoria circuitoChico, Categoria circuitoMedio, Categoria circuitoAvanzado){


        for (Participante participante : setParticipantes ) {
            String categoria = participante.getCatPedida().getTipo();
            switch (categoria) {
                case "Chico" : {
                    Inscripcion inscripcionChico = new Inscripcion(participante.getNumeroParticipante(), circuitoChico, participante);
                    listChico.add(inscripcionChico);
                    break;
                }
                case "Medio" : {
                    Inscripcion inscripcionMedio = new Inscripcion(participante.getNumeroParticipante(), circuitoMedio, participante);
                    listMedio.add(inscripcionMedio);
                    break;
                }
                case "Avanzado" : {
                    Inscripcion inscripcionAvanzado = new Inscripcion(participante.getNumeroParticipante(), circuitoAvanzado, participante);
                    listAvanzado.add(inscripcionAvanzado);
                    break;
                }

            }
        }
    }

    public static void showInfoInscripciones (HashMap<String, List<Inscripcion>> inscripciones) {
        double montoTotalCarreras = 0;
        for(Map.Entry<String, List<Inscripcion>> inscripcion : inscripciones.entrySet())
        {
            System.out.println("Categoria: " + inscripcion.getKey());
            List<Inscripcion> listaIns = inscripcion.getValue();
            double montoPorCat = 0;
            for(Inscripcion ins : listaIns )
            {
                ins.getParticipante().mostrarDatos();
                System.out.println("Numero de inscripcion: " + ins.getNumero());
                System.out.println(ins.calcularMonto());
                montoPorCat += ins.calcularMonto();
            }
            System.out.println("El monto total de la categoria " + inscripcion.getKey() + " es de " + montoPorCat + "$");
            System.out.println();
            listaIns.remove(0);
            for(Inscripcion ins : listaIns )
            {
                System.out.println("MUESTRO LA LISTA LUEGO DE REMOVER A UN PARTICIPANTE");
                ins.getParticipante().mostrarDatos();
            }
            montoTotalCarreras += montoPorCat;
            System.out.println();
            System.out.println();
        }
        System.out.println("El monto total de toda la carrera es de " + montoTotalCarreras + "$");

    }

    public static void main(String[] args) {

        Categoria circuitoChico = new Categoria("Chico", 2, "Selva y arroyos");
        Categoria circuitoMedio = new Categoria("Medio", 5, "Selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria("Avanzado", 10, "Selva, arroyos, barro y escalada");

        Participante participante1 = new Participante(1, 445676, "Carlos", "Sanchez",
                23, "12-34", "123-45", "A+", circuitoChico);
        Participante participante2 = new Participante(2, 475676, "Lionel", "Messi",
                38, "555-777", "555-778", "0-", circuitoMedio);
        Participante participante3 = new Participante(3, 49876, "Cristi", "Ronaldo",
                40, "777-555", "777-556", "B+", circuitoMedio);
        Participante participante4 = new Participante(4, 4987677, "Rodri", "De paul",
                33, "888-555", "888-556", "A+", circuitoChico);
        Participante participante5 = new Participante(5, 4980076, "Lea", "Paredes",
                34, "999-555", "999-556", "B+", circuitoAvanzado);


        Set<Participante> setParticipantes = new HashSet<>();
        setParticipantes.add(participante1);
        setParticipantes.add(participante2);
        setParticipantes.add(participante3);
        setParticipantes.add(participante4);
        setParticipantes.add(participante5);

        List<Inscripcion> listChico = new ArrayList<>();
        List<Inscripcion> listMedio = new ArrayList<>();
        List<Inscripcion> listAvanzado = new ArrayList<>();
        generarListasInscripciones(listChico, setParticipantes, listMedio, listAvanzado, circuitoChico, circuitoMedio, circuitoAvanzado);

        HashMap<String, List<Inscripcion>> inscripciones = new HashMap<>();
        inscripciones.put("Chico", listChico);
        inscripciones.put("Medio", listMedio);
        inscripciones.put("Avanzado", listAvanzado);

        showInfoInscripciones(inscripciones);


    }
}
