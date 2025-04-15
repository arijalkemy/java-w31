package co.com.mercadolibre.linkTracker.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Link {

    private Long id;
    private String url;
    private String password;
    private boolean isValid;
    private int redirectCount;

    public Link() {
        this.id = counter();
    }

    public Link(String url, String password, boolean isValid, int redirectCount) {
        this.url = url;
        this.password = password;
        this.isValid = isValid;
        this.redirectCount = redirectCount;
    }

    public Long counter(){
        return this.id++;
    }
}
