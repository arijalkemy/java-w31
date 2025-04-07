//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SerieEntera serieEnteraDeDos = new SerieEntera(2);
        System.out.println(serieEnteraDeDos.siguienteValor());
        System.out.println(serieEnteraDeDos.siguienteValor());

        serieEnteraDeDos.establecerValorInicial(1);
        System.out.println(serieEnteraDeDos.siguienteValor());
        System.out.println(serieEnteraDeDos.siguienteValor());

        SerieDouble serieDoubleDeTres = new SerieDouble(3.0);
        System.out.println(serieDoubleDeTres.siguienteValor());
        System.out.println(serieDoubleDeTres.siguienteValor());
    }
}