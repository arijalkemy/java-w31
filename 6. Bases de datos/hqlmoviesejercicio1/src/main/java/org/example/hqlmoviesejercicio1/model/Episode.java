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
@Table(name = "episodes")
public class Episode {

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

    @Column(name="rating")
    private BigDecimal rating;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="season_id",referencedColumnName = "id")
    private Season season;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "actor_episode",
            joinColumns = @JoinColumn(name = "episode_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;
}
