package co.com.mercadolibre.practicadeportistas.practicadeportistas.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.enums.SPORT_LEVEL;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class SportDto {

    private String name;
    private SPORT_LEVEL nLevel;

    public SportDto(String name, SPORT_LEVEL nLevel) {
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
