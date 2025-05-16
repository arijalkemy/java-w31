package com.example.LasPerlas.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Data
@Entity
@SQLDelete(sql = "UPDATE JEWEL SET for_sale = false WHERE id = ?")
@Where(clause = "for_sale = true")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    String name;
    String material;
    int weight;
    String details;
    boolean hasStone;
    boolean forSale;
}
