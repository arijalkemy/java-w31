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
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Timestamp crearedAt;
    private Timestamp updatedAt;
    private String title;
    private Date releaseDate;
    private Date endDate;

    @OneToMany
    private Set<Season> seasons;

    @ManyToOne
    @JoinColumn(name = "genreId",nullable = false)
    private Genre genre;

}
