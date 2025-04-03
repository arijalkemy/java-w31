package org.series_numericas.clases;

public class SeriePar extends Prototipo {
    private Integer value;

    public SeriePar() {
        super();
        this.value = 0;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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
        if(value % 2 != 0) {
            System.out.println("El numero debe ser par");
        } else {
            this.value = value;
            System.out.println(this.value);
        }
    }
}
