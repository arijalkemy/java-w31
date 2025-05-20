package com.mercadolibre.movies.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "migrations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Migration {

    @Id
    private Long id;

    @Column(nullable = false, length = 255)
    private String migration;

    @Column(nullable = false)
    private Integer batch;
}
