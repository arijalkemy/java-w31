package co.com.mercadolibre.seriesnumericas;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("---------- PRIMER CASO: Serie de 2 (por defecto) ----------");
        FirstSubClass serieDosDefault = new FirstSubClass();
        System.out.println("1ra llamada: " + serieDosDefault.devolverSiguienteValorDeSerieNumerica(null)); // 2
        System.out.println("2da llamada: " + serieDosDefault.devolverSiguienteValorDeSerieNumerica(null)); // 4
        System.out.println("3ra llamada: " + serieDosDefault.devolverSiguienteValorDeSerieNumerica(null)); // 6
        System.out.println("4ta llamada: " + serieDosDefault.devolverSiguienteValorDeSerieNumerica(null)); // 8
        
        System.out.println("\n---------- SEGUNDO CASO: Serie de 2 con valor inicial 1 ----------");
        FirstSubClass serieDosConInicial = new FirstSubClass();
        serieDosConInicial.establecerValorInicialDeLaSerie(1);
        System.out.println("1ra llamada: " + serieDosConInicial.devolverSiguienteValorDeSerieNumerica(null)); // 3
        System.out.println("2da llamada: " + serieDosConInicial.devolverSiguienteValorDeSerieNumerica(null)); // 5
        System.out.println("3ra llamada: " + serieDosConInicial.devolverSiguienteValorDeSerieNumerica(null)); // 7
        System.out.println("4ta llamada: " + serieDosConInicial.devolverSiguienteValorDeSerieNumerica(null)); // 9
        
        System.out.println("\n---------- TERCER CASO: Serie de 3 (SecondSubClass) ----------");
        SecondSubClass serieTres = new SecondSubClass();
        serieTres.establecerValorInicialDeLaSerie(3);
        System.out.println("1ra llamada: " + serieTres.devolverSiguienteValorDeSerieNumerica(null)); // 3
        System.out.println("2da llamada: " + serieTres.devolverSiguienteValorDeSerieNumerica(null)); // 6
        System.out.println("3ra llamada: " + serieTres.devolverSiguienteValorDeSerieNumerica(null)); // 9
        System.out.println("4ta llamada: " + serieTres.devolverSiguienteValorDeSerieNumerica(null)); // 12
    }
}