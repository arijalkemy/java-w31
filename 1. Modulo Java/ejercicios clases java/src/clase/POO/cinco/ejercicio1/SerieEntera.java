package clase.POO.cinco.ejercicio1;

public class SerieEntera extends Prototipo<Integer>{
    public SerieEntera(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer siguiente() {
        valorActual += incremento;
        return valorActual;
    }
}
