package co.com.mercadolibre.linkTracker.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class LinkDto {

    private Long id;
    private String url;
    private String password;
    private boolean isValid;
    private int redirectCount;

    public LinkDto(String url, String password, boolean isValid, int redirectCount) {
        this.url = url;
        this.password = password;
        this.isValid = isValid;
        this.redirectCount = redirectCount;
    }

    public LinkDto(Long id) {
        this.id = id;
    }

    
    
}
