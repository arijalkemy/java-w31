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
@Table(name="actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="rating")
    private BigDecimal rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="favorite_movie_id",referencedColumnName = "id")
    private Movie movie;

    @JsonIgnore
    @ManyToMany(mappedBy = "actorsMovies")
    private List<Movie> movies;

    @JsonIgnore
    @ManyToMany(mappedBy = "actors")
    private List<Episode> episodes;

}
