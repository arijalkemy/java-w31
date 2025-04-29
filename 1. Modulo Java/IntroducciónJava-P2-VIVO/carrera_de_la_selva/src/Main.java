import javax.swing.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Se intentará resolver sin utilizar POO, y utilizando solo las herramientas vistas hasta la fecha
        // (POR LO QUE LA ESTRUCTURA RESULTANTE ES UN POCO TOSCA Y MONOLITICA)
        // se representarán las categorías con maps
        Map<String, String> circuitoChico = new HashMap<String, String>();
        circuitoChico.put("tipoCircuito", "chico");
        circuitoChico.put("descripcion", "2 km por selva y arroyos.");
        circuitoChico.put("-18", "1300");
        circuitoChico.put("+18", "1500");

        Map<String, String> circuitoMedio = new HashMap<String, String>();
        circuitoMedio.put("tipoCircuito", "medio");
        circuitoMedio.put("descripcion", "5 km por selva, arroyos y barro.");
        circuitoMedio.put("-18", "2000");
        circuitoMedio.put("+18", "2300");

        Map<String, String> circuitoGrande = new HashMap<String, String>();
        circuitoGrande.put("tipoCircuito", "grande");
        circuitoGrande.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");
        circuitoGrande.put("-18", "");
        circuitoGrande.put("+18", "2800");

        //guardo las categorías por una cuestión de orden en una lista,
        //las posiciónes de cada categoría se usarán como id

        List<Map<String, String>> categorias = new ArrayList<Map<String, String>>();
        categorias.add(circuitoChico);
        categorias.add(circuitoMedio);
        categorias.add(circuitoGrande);

        Scanner scanner = new Scanner(System.in);

        // Los participantes se guardarán en un List
        List<Map<String, String>> participantes = new ArrayList<Map<String, String>>();

        // Las inscripciones se representan/guardan en una Lista
        List<String[]> inscripciones = new ArrayList<String[]>();

        int numInscripcion = 0;
        String stopFlag = "Y";
        String menu = "";
        boolean exit = false;
        while (!exit) {
            System.out.println("Presione\n" +
                    "1 para INSCRIBIR participantes\n" +
                    "2 para ELIMINAR inscripción\n" +
                    "3 para MOSTRAR inscripciones por categoría\n" +
                    "4 para MOSTRAR el MONTO recaudado por categoría y el monto total\n" +
                    "Cualquier otra tecla para SALIR\n");

            menu = scanner.nextLine();
            switch (menu) {
                // se representan los participantes con maps
                case "1":
                    while (!stopFlag.equalsIgnoreCase("N")) {
                        numInscripcion++;
                        System.out.println("INSCRIPCIÓN DE PARTICIPANTES");
                        Map<String, String> participante = new HashMap<String, String>();

                        //System.out.print("Número de participante: ");
                        participante.put("Id", String.valueOf(participantes.size()+1));

                        System.out.print("DNI: ");
                        participante.put("dni", scanner.nextLine());

                        System.out.print("Nombre: ");
                        participante.put("nombre", scanner.nextLine());

                        System.out.print("Apellido: ");
                        participante.put("apellido", scanner.nextLine());

                        System.out.print("Edad: ");
                        participante.put("edad", scanner.nextLine());

                        System.out.print("Celular: ");
                        participante.put("celular", scanner.nextLine());

                        System.out.print("Número de emergencia: ");
                        participante.put("emergencia", scanner.nextLine());

                        System.out.print("Grupo sanguíneo: ");
                        participante.put("grupo", scanner.nextLine());

                        participantes.add(participante);
                        System.out.print("Número de categoria (0-Chico, 1-Medio, 2-Grande): ");
                        String indiceCategoria = scanner.nextLine().toLowerCase();

                        String monto = "";
                        if (Integer.parseInt(participante.get("edad")) < 18) {
                            monto = (categorias.get(Integer.parseInt(indiceCategoria))).get("-18");

                        } else {
                            monto = (categorias.get(Integer.parseInt(indiceCategoria))).get("+18");
                        }
                        if (monto.isEmpty()) {
                            System.out.println("No se permiten inscripciones a menores de 18 años en esta categoría.");
                            continue;
                        }
                        inscripciones.add(new String[]{String.valueOf(numInscripcion), indiceCategoria, String.valueOf(participantes.size()), monto});
                        System.out.println("Desea registrar otro participante? Y/N");
                        stopFlag = scanner.nextLine();
                    }
                    break;
                case "2":
                    System.out.println("ELIMINACIÓN DE PARTICIPANTES");
                    System.out.println("Para eliminar un participante ingrese su Número de participante: ");
                    String toRemove = scanner.nextLine();
                    participantes.removeIf(p -> toRemove.equals(p.get("Id")));
                    /*for (Map<String, String> participante : participantes) {
                        if (toRemove.equals(participante.get("Id"))) {
                            participantes.remove(participante);
                        }
                    };*/
                    break;
                case "3":
                    System.out.println("Inscripciones por categoría");
                    System.out.println("Ingrese la categoría a mostrar (0-Chico, 1-Medio, 2-Grande): ");
                    int seleccion = scanner.nextInt();
                    System.out.println("Categoría seleccionada: ");
                    //System.out.println(categorias.get(seleccion).toString());
                    System.out.println("Tipo de circuito: "+(categorias.get(seleccion)).get("tipoCircuito"));
                    System.out.println("Descripción: "+(categorias.get(seleccion)).get("descripcion"));

                    System.out.println("Inscriptos: ");
                    for (String[] inscripcion : inscripciones) {
                        if(inscripcion[1].equals(Integer.toString(seleccion))){
                            //VER SI FUNCIONA O SI IMPRIME MAL LOS PARTICIPANTES, LO IDEAL SERÍA IMPRIMIR DATOS UNO A UNO CON SU SIGNIFICADO
                            System.out.println("Inscripcion número: " + (inscripcion[0]));
                            //---------------------
                            Map<String, String> inscrito = participantes.get(Integer.parseInt(inscripcion[2])-1);
                            if(inscrito.isEmpty()){
                                System.out.println("No se encuentran inscriptos en esta categoría.");
                            }
                            System.out.println("Participante inscripto: "+inscrito.get("nombre")+" "+inscrito.get("apellido"));
                            System.out.println("Monto pagado: " + (inscripcion[3])+"\n-----------------------------------------");
                        };
                    }
                    break;



                case "4":
                    int subTotUno = 0;
                    int subTotDos = 0;
                    int subTotTres = 0;
                    int total = 0;
                    System.out.println("Mostrar monto recaudado por categoría y monto total");
                    for(String[] inscripcion : inscripciones) {
                        total += Integer.parseInt(inscripcion[3]);
                        switch (inscripcion[1]) {
                            case "0":
                                subTotUno += Integer.parseInt(inscripcion[3]);
                            case "1":
                                subTotDos += Integer.parseInt(inscripcion[3]);
                            case "2":
                                subTotTres += Integer.parseInt(inscripcion[3]);
                        }
                    }
                    System.out.println("Total categoría circuito "+ (categorias.get(0)).get("tipoCircuito"+": "+subTotUno)); //ver si me toma el subtot como string
                    System.out.println("Total categoría circuito "+ (categorias.get(1)).get("tipoCircuito"+": "+subTotDos)); //ver si me toma el subtot como string
                    System.out.println("Total categoría circuito "+ (categorias.get(2)).get("tipoCircuito"+": "+subTotTres)); //ver si me toma el subtot como string

                    System.out.println("Total: " + total);
                    break;

                default:
                    exit = true;
                    break;
            }
        }

    }
}
