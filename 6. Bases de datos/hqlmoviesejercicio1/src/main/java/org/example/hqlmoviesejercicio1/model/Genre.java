package org.example.hqlmoviesejercicio1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="name")
    private String name;

    @Column(name="ranking")
    private Integer ranking;

    @Column(name = "active")
    private Boolean active;

    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<Serie> series;

    @JsonIgnore
    @OneToMany(mappedBy = "genre")
    private List<Movie> movies;
}
