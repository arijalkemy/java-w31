package bootcamp.carrera;

import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        double totalCircuitoChico = 0;
        double totalCircuitoMediano = 0;
        double totalCircuitoGrande = 0;
        double totalGeneral = 0;
        Map<Atleta, Inscripcion> incripciones = new HashMap<Atleta, Inscripcion>();
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "Circuito de 2km");
        Categoria circuitoMediano = new Categoria(2, "Circuito mediano", "Circuito de 5km");
        Categoria circuitoGrande = new Categoria(3, "Circuito grande", "Circuito de 10km");
        Atleta atleta1 = new Atleta(1, 12345678, "Juan", "Pérez", 17, "123456789", "987654321", "O+");
        Atleta atleta2 = new Atleta(1, 23456781, "Pedro", "Pascal", 35, "123456789", "987654321", "O+");
        Atleta atleta3 = new Atleta(1, 34567812, "Maximo Decimo", "Meridio", 40, "123456789", "987654321", "O+");
        Inscripcion inscripcion1 = new Inscripcion(1, circuitoChico, atleta1);
        Inscripcion inscripcion2 = new Inscripcion(2, circuitoMediano, atleta2);
        Inscripcion inscripcion3 = new Inscripcion(3, circuitoGrande, atleta3);

        incripciones.put(atleta1, inscripcion1);
        incripciones.put(atleta2, inscripcion2);
        incripciones.put(atleta3, inscripcion3);

        for( Map.Entry<Atleta, Inscripcion> entry : incripciones.entrySet()) {
            Atleta atleta = entry.getKey();
            Inscripcion inscripcion = entry.getValue();

            if(inscripcion.getCategoria() == circuitoChico && atleta.getEdad() < 18) {
                inscripcion.setMonto(1300.0);
            } else if(inscripcion.getCategoria() == circuitoChico && atleta.getEdad() >= 18) {
                inscripcion.setMonto(1500.0);
            } else if(inscripcion.getCategoria() == circuitoMediano && atleta.getEdad() < 18) {
                inscripcion.setMonto(2000.0);
            } else if(inscripcion.getCategoria() == circuitoMediano && atleta.getEdad() >= 18) {
                inscripcion.setMonto(2300.0);
            } else if(inscripcion.getCategoria() == circuitoGrande) {
                inscripcion.setMonto(2800.0);
            }

            System.out.println("El atleta " + atleta.getNombre() + " " + atleta.getApellido() + " abona un total de " + inscripcion.getMonto() + " por la inscripción al circuito.");

            if (inscripcion.getCategoria().equals(circuitoMediano)) {
                System.out.println(inscripcion.getAtleta().toString());
            }

            double monto = inscripcion.getMonto();
            totalGeneral += monto;

            if (inscripcion.getCategoria() == circuitoChico) {
                totalCircuitoChico += monto;
            } else if (inscripcion.getCategoria() == circuitoMediano) {
                totalCircuitoMediano += monto;
            } else if (inscripcion.getCategoria() == circuitoGrande) {
                totalCircuitoGrande += monto;
            }
        }

        System.out.println("Total recaudado por Circuito Chico: " + totalCircuitoChico);
        System.out.println("Total recaudado por Circuito Mediano: " + totalCircuitoMediano);
        System.out.println("Total recaudado por Circuito Grande: " + totalCircuitoGrande);
        System.out.println("Total recaudado en toda la carrera: " + totalGeneral);

    }
}