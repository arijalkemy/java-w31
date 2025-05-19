package org.example.hqlmoviesejercicio1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movie {

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

    @Column(name="rating")
    private BigDecimal rating;

    @Column(name="awards")
    private Integer awards;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name="length")
    private Integer length;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="genre_id",referencedColumnName = "id")
    private Genre genre;

    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private List<Actor> actors;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "actor_movie",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actorsMovies;

}
