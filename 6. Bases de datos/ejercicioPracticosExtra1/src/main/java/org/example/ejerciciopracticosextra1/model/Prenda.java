package org.example.ejerciciopracticosextra1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prendas")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo")
    private Tipo tipo;

    @Column(name = "marca")
    private String marca;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
    private Color color;

    @Enumerated(EnumType.STRING)
    @Column(name = "talla")
    private Talla talla;

    @Column(name = "cantidad")
    private Long cantidad;

    @Column(name = "precio_venta")
    private Double precioVenta;

    private enum Tipo {PANTALON, CAMISA, CAMISETA, SOMBRERO, ACCESORIO, JEAN};

    public enum Talla {XS,S,M,L,XL}

    private enum Color {ROJO,AMARILLO,AZUL,BLANCO,NEGRO,GRIS,VERDE}

}
