package ejercicio2;

import java.util.Locale;

public abstract class Documento implements Imprimible{


    public abstract void imprimir();

    @Override
    public void imprimirTipoDoc(){
        System.out.println("----------- " + getClass().getSimpleName().toUpperCase() + " ------------");
    }
}
