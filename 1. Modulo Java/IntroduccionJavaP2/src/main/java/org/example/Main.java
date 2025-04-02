package org.example;

import org.example.models.Categoria;
import org.example.models.Inscripcion;
import org.example.models.Participante;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //a) Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria(1, "circuito_chico", "2 km por selva y arroyos"));
        categorias.add(new Categoria(2, "circuito_medio", "5 km por selva, arroyos y barro"));
        categorias.add(new Categoria(3, "circuito_avanzado", "10 km por selva, arroyos, barro y escalada en piedra"));

        //b) Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
        Participante participante1 = new Participante(1,"123","Juan","Duran",20,"233223","23232","B+");
        Inscripcion inscripcion1 = new Inscripcion(1,categorias.get(0),participante1);
        List<Inscripcion> inscripciones = new ArrayList<>();
        inscripciones.add(inscripcion1);

        //c) inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        Participante participante2 = new Participante(2,"555","Antonio","Macias",30,"66445","66643","A+");
        Inscripcion inscripcion2 = new Inscripcion(2,categorias.get(1),participante2);
        inscripciones.add(inscripcion2);
        Participante participante3 = new Participante(3,"444","Luis","Castañeda",45,"77788","77774","AB+");
        Inscripcion inscripcion3 = new Inscripcion(3,categorias.get(2),participante3);
        inscripciones.add(inscripcion3);

        double totalCategoria0 = 0;
        double totalCategoria1 = 0;
        double totalCategoria2 = 0;

        for(Inscripcion inscripcion : inscripciones){
            switch (inscripcion.getCategoria().getNombre()){
                case "circuito_chico":

                    if(inscripcion.getParticipante().getEdad()<18){
                        inscripcion.setMonto(1300);
                    }else{
                        inscripcion.setMonto(1500);
                    }
                    totalCategoria0+=inscripcion.getMonto();
                    break;
                case "circuito_medio":

                    if(inscripcion.getParticipante().getEdad()<18){
                        inscripcion.setMonto(2000);
                    }else{
                        inscripcion.setMonto(2300);
                    }
                    totalCategoria1+=inscripcion.getMonto();
                    break;
                case "circuito_avanzado":

                    if(inscripcion.getParticipante().getEdad()<18){
                        //No se permite inscripcion
                        continue;
                    }else{
                        inscripcion.setMonto(2800);
                    }
                    totalCategoria2+=inscripcion.getMonto();
                    break;

                default: break;
            }
        }
        System.out.println("INGRESOS");
        System.out.println(categorias.get(0).getNombre()+": "+totalCategoria0);
        System.out.println(categorias.get(1).getNombre()+": "+totalCategoria1);
        System.out.println(categorias.get(2).getNombre()+": "+totalCategoria2);
        System.out.println("TOTAL: "+(totalCategoria0+totalCategoria1+totalCategoria2));


        //d) Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        for(Inscripcion inscripcion : inscripciones){
            if(inscripcion.getCategoria().getNombre().equals("circuito_chico")){
                System.out.println("Inscripción N°"+inscripcion.getId()+"\n"+
                        "ID: "+inscripcion.getParticipante().getId()+"\n"+
                        "Nombre: "+inscripcion.getParticipante().getNombre()+"\n"+
                        "Apellido: "+inscripcion.getParticipante().getApellido()+"\n"+
                        "DNI: "+inscripcion.getParticipante().getDni()+"\n"+
                        "Celular: "+inscripcion.getParticipante().getCelular()+"\n"+
                        "Numero de Emergencia: "+inscripcion.getParticipante().getNumeroEmergencia()+"\n"+
                        "Grupo Sanguineo: "+inscripcion.getParticipante().getGrupoSanguineo()+"\n"+
                        "Edad: "+inscripcion.getParticipante().getEdad()+"\n"
                );
            }
        }

        //e) Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        inscripciones.removeLast();
        System.out.println("Total de inscripciones: "+inscripciones.size());
    }
}