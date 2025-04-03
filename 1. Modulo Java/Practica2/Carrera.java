package Practica2;

import java.util.ArrayList;
import java.util.HashMap;

public class Carrera {
	
	
	private ArrayList<Participante>	participantes;	
	private ArrayList<Categoria>	categorias;	
	private ArrayList<Inscripcion>	inscripciones;	
	
    public Carrera() {
    	categorias = new  ArrayList<Categoria>();
    	inscripciones = new  ArrayList<Inscripcion>();
    	participantes = new  ArrayList<Participante>();
	}

    public void crearCategorias() {
    	categorias.add(new Categoria(01 ,"Circuito chico" ,"2 km por selva y arroyos." , true , true , 1300 , 1500));
    	categorias.add(new Categoria(02 ,"Circuito medio" ,"5 km por selva, arroyos y barro.", true , true , 2000 , 2300 ));
    	categorias.add(new Categoria(02 ,"Circuito avanzado" ,"10 km por selva, arroyos, barro y escalada en piedra", false , true , 0 , 2800 ));
    }
    
    public void inscribirParticipante(int nroInscripcion, Participante participante , int idCategoria) {
    	
    	Categoria categoriaEncontrada = null;
    	   for (Categoria categoria : categorias) {
               if (categoria.getId() == idCategoria) {
                   categoriaEncontrada = categoria;
                   break; 
               }
           }
    	   
    	inscripciones.add(new Inscripcion(nroInscripcion , categoriaEncontrada , participante ));
  
    }
    
    public void inscribirParticipantesAlAzar(ArrayList<Participante> participantes) {
    	
    }
    
    public void mostrarParticipantes(int idCategoria) {
    	
    }
    
    public void desinnscribirParticipante(int idParticipante) {
    	
    }
    
    public void calcularMontoRecaudado() {
    	
    	
    }
    
    
    
	//Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
	//Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
	//Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
	//Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
	//Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
	//Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.



}
