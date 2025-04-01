package carreraDeLaSelva;

public class Categoria {
    public static final int EDAD_ADULTO = 18;
    TipoCategoria tipo;
    String categoriaNombre;
    int edadMinima;
    int costoMayores;
    int costoMenores;
    String[] terrenos;
    double largo;

    public Categoria(TipoCategoria tipo, String categoriaNombre, int costoMayores, int costoMenores, boolean paraAdultos, String[] terrenos, double largo) {
        this.tipo = tipo;
        this.categoriaNombre = categoriaNombre;
        this.costoMayores = costoMayores;
        if (paraAdultos) {
            this.edadMinima = EDAD_ADULTO;
        } else {
            this.edadMinima = 0;
        }
        this.terrenos = terrenos;
        this.costoMenores = costoMenores;
        this.largo = largo;
    }

    public boolean admiteMenores() {
        return this.edadMinima < EDAD_ADULTO;
    }

    public TipoCategoria getTipo() {
        return tipo;
    }

    public int getCosto(int edad) {
        if (edad >= EDAD_ADULTO) {
            return costoMayores;
        } else {
            return costoMenores;
        }
    }

    public String printTipo() {
        if (this.tipo == TipoCategoria.MEDIANA) {
            return "Mediana";
        } else if (this.tipo == TipoCategoria.AVANZADA) {
            return "Avanzada";
        }

        return "Chica";
    }
}
