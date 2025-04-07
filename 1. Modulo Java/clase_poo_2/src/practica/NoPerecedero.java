package practica;
public class NoPerecedero extends Producto{
    private String tipo;

    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public NoPerecedero(String tipo, String nombre, double precio){ 
        super(nombre, precio);
        this.tipo = tipo ;
    };
    public String toString(){
        return "Tipo del producto: " + tipo;
    }

    @Override
    public int calcular(int cantidad){
        return super.calcular(cantidad);
    }

}
