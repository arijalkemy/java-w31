package ejercicioproto;

public class Main {

    public static void showSerie (Prototipo serie){
        for(int i = 0; i <= 5; i++){
            System.out.println(serie.nextValue());
        }
    }

    public static void main(String[] args) {
        SerieDos<Integer> serieDos = new SerieDos<>(2);
        SerieUno<Integer> serieUno = new SerieUno<>(1);
        SerieDos<Integer> serieTres = new SerieDos<>(3);
        showSerie(serieDos);
        System.out.println();
        showSerie(serieUno);
        System.out.println();
        showSerie(serieTres);
        serieDos.rebootSerie();


    }


}
