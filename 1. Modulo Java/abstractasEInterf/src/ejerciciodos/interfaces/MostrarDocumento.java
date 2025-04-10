package ejerciciodos.interfaces;

public interface MostrarDocumento {

    static void mostrarDoc (MostrarDocumento documento) {
        System.out.println(documento.mostrar());
    }

    String mostrar();
}
