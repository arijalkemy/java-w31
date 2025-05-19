package org.example.hqlmoviesejercicio1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="title")
    private String title;

    @Column(name="number")
    private Integer number;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name="end_date")
    private Date endDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="serie_id",referencedColumnName = "id")
    private Serie serie;

    @JsonIgnore
    @OneToMany(mappedBy = "season")
    private List<Episode> episodes;
}
