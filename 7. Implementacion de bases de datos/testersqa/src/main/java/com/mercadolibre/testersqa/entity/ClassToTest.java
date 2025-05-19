package com.mercadolibre.testersqa.entity;

import jakarta.persistence.*;

@Entity
@Table
public class ClassToTest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nameClass;

}
