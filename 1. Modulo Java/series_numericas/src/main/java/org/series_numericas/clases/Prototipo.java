package org.series_numericas.clases;

public abstract class Prototipo {
    private Integer value;

    public Integer returnProgresiveNumber(Integer value) {
        return this.value + value;
    }

    public  void resetProgresiveNumber() {
        this.value = 0;
    }

    public void setInitialProgresiveNumber(Integer value) {
        this.value = value;
    }
}
