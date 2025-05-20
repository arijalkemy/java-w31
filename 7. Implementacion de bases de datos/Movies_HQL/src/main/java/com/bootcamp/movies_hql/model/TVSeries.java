package com.bootcamp.movies_hql.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "series")
public class TVSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer numberOfSeasons;

    @OneToMany(mappedBy = "tvSeries", cascade = CascadeType.ALL)
    private List<Episode> episodes;
}

