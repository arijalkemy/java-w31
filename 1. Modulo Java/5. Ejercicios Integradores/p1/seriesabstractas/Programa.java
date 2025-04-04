package seriesabstractas;

public class Programa {
    public static void main(String[] args) {
        SerieDeDos serieDeDos = new SerieDeDos(0, 2);
        SerieDeTres serieDeTres = new SerieDeTres(0, 3);

        System.out.println("Serie de dos:");
        serieDeDos.getValorActual();
        serieDeDos.getValorSiguiente();
        serieDeDos.getValorSiguiente();
        serieDeDos.resetSeries();

        System.out.println("\nSerie de tres:");
        serieDeTres.getValorActual();
        serieDeTres.getValorSiguiente();
        serieDeTres.getValorSiguiente();
        serieDeTres.resetSeries();
    }
}
