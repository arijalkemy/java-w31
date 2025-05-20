package com.mercadolibre.movies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "password_resets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(PasswordResetKey.class)
public class PasswordReset {

    @Id
    private String email;

    @Id
    private String token;

    private LocalDateTime createdAt;

}
