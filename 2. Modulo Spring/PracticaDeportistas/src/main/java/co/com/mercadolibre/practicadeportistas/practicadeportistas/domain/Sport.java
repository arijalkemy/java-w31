    package co.com.mercadolibre.practicadeportistas.practicadeportistas.domain;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.enums.SPORT_LEVEL;

public class Sport {

    private String name;
    private SPORT_LEVEL nLevel;

    public Sport(String name, SPORT_LEVEL nLevel) {
        this.name = name;
        this.nLevel = nLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SPORT_LEVEL getnLevel() {
        return nLevel;
    }

    public void setnLevel(SPORT_LEVEL nLevel) {
        this.nLevel = nLevel;
    }


}
