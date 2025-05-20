package com.mercadolibre.miniseries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp crearedAt;
    private Timestamp updatedAt;
    private String title;
    private Integer number;
    private Date releaseDate;
    private Date endDate;

    @OneToMany
    private Set<Episode> episodes;

    @ManyToOne
    @JoinColumn(name = "serieId",nullable = false)
    private Serie serie;

}
