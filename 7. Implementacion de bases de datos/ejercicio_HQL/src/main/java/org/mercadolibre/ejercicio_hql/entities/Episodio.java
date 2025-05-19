package org.mercadolibre.ejercicio_hql.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "episodes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Episodio {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "number")
    private int number;

    @Column(name = "rating")
    private double rating;

    //@ManyToOne
    //@JoinColumn(name = "season_id", referencedColumnName = "id")
    //private Serie seasonId;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDate.now();
    }

}
