package bootcamp.abstracciones_interfaces.ej1.interfaces;

public interface Transaccion {
    //Use default ya que nunca antes lo habia utilizado
    default void transaccionOk() {
        System.out.println("Transacción exitosa");
    };
    default void transaccionNoOk(){
        System.out.println("Transacción fallida");
    };
}
