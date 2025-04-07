public class Main {
    public static void main(String[] args) {
        Curriculum curriculum1 = new Curriculum("aaron", "gerez", 24, "2343234");
        curriculum1.agregarHabilidad("excel");
        curriculum1.agregarHabilidad("python");
        curriculum1.agregarHabilidad("java");

        Imprimible.imprimirDoc(curriculum1);

        PDF libro1 = new PDF("J K Rowling", "Harry Potter", "Ficcion", 800);
        Imprimible.imprimirDoc(libro1);

        Informes informe1 = new Informes("aaron gerez", "este es un texto de un informe sobre...", "esteban terrabusi", 7);
        Imprimible.imprimirDoc(informe1);
    }
}
