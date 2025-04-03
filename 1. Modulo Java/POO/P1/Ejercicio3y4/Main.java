package P1.Ejercicio3y4;

/*
 * Ejercicio 3
 * Creá una clase nueva llamada Main, donde declares un método main
 * como te enseñamos anteriormente. Esto nos permitirá ejecutar
 * nuestra aplicación.
 */

/*
 * Ejercicio 4
 * En la clase Main que acabamos de crear, dentro del método main()
 * te pedimos que crees un objeto de tipo Persona por cada constructor
 * que hayamos definido en la clase, recuerda poner un nombre
 * significativo a las variables donde vas a asignar cada objeto.
 * ¿Cómo lo harías? A continuación vamos a crear otro objeto de tipo
 * persona y vamos a construirlo pasando solamente un valor para el
 * nombre y otro para la edad en el constructor. ¿Es esto posible?
 * ¿Qué sucede si tratamos de hacer esto?
*/
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Ana", 25, "12345678");
        Persona persona3 = new Persona("Juan", 30, "87654321", 70.5, 1.75);

        // Creando un objeto de tipo Persona con solo nombre y edad
        // Esto no es posible ya que la clase Persona no tiene un constructor que acepte solo nombre y edad
        // Persona persona4 = new Persona("Pedro", 40); // Esto generará un error
    }
}
