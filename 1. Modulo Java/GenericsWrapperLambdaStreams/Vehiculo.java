package GenericsWrapperLambdaStreams;

/* 
 * Ejercicio 1
 * Inicia creando una clase Vehículo con los atributos modelo, marca y costo.
 * Luego crea una clase garaje con los atributos id o identificador único y
 * una lista de vehículos. Crea además los constructores de las clases y los
 * métodos Setter y Getter.
 */
public class Vehiculo {
    String modelo;
    String marca;
    int costo;

    public Vehiculo(String modelo, String marca, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
}
