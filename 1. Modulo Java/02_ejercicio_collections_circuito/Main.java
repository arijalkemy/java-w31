public class Main {
    public static void main(String[] args) {
        Inscripcion inscripciones = new Inscripcion();

        Persona personaCircuitoChico = new Persona("Juan", "Perez", 30, 2939238,
                "11288327", "737271", "positivo");
        Circuito circuitoChico = new CircuitoChico();
        Persona personaCircuitoChicoDos = new Persona("Juan", "Menor", 10, 29398,
                "11288327", "737271", "positivo");
        Persona personaCircuitoMedio = new Persona("Nicolas", "Cundari", 30, 38440109,
                "11726666", "32323", "a");


        Persona menorCircuitoGrande = new Persona("Menor", "Menor", 10, 21, "",
                "", "");

        Circuito circuitoGrande = new CircuitoGrande();
        Circuito circuitoMedio = new CircuitoMedio();


        inscripciones.inscribir(personaCircuitoChicoDos, circuitoChico);
        inscripciones.inscribir(personaCircuitoChico,circuitoChico);
        inscripciones.inscribir(personaCircuitoMedio, circuitoMedio);

        inscripciones.inscribir(personaCircuitoMedio, circuitoChico);

        inscripciones.inscribir(menorCircuitoGrande, circuitoGrande);

        inscripciones.desinscribir(404000);
        inscripciones.inscriptos();
        inscripciones.inscriptosDeCircuito(circuitoMedio);
        System.out.println("La suma de todas los montos: " + inscripciones.montoTotalDeTodasLasCategorias());
        System.out.println("La suma de los montos a pagar para circuito chico: " + inscripciones.montoTotalPorCategoria(circuitoChico));
    }
}
