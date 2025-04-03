package org.series_numericas.clases;

public class SerieCustom extends Prototipo{
    private Integer value;

    public SerieCustom() {
        this.value = 0;
    }

    @Override
    public Integer returnProgresiveNumber(Integer value) {
        this.value += value;
        return this.value;
    }

    @Override
    public void resetProgresiveNumber() {
        this.value = 0;
        System.out.println("Se reinicio el progresive number");
    }

    @Override
    public void setInitialProgresiveNumber(Integer value) {
        this.value = value;
        System.out.println(value);
    }
}
