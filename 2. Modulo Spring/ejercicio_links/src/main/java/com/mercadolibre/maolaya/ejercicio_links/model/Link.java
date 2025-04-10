package com.mercadolibre.maolaya.ejercicio_links.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Link {
    private Integer id;
    private Boolean isValid = Boolean.TRUE;
    private String link;
    private Integer calls = 0;
    private String password;

    public Link(Integer id, String link, String password) {
        this.id = id;
        this.link = link;
        this.password = password;
    }

    public void invalidateLink() {
        this.isValid = Boolean.FALSE;
    }

    public void call() {
        calls++;
    }

    public boolean hasPassword() {
        return !this.password.equals("");
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
}
