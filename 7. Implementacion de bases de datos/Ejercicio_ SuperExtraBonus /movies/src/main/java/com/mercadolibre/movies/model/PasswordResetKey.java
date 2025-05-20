package com.mercadolibre.movies.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class PasswordResetKey implements Serializable {

    private String email;
    private String token;


}
