package com.mercadolibre.obrasliterarias.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "obra")
public class ObraLiteraria {

    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String nombre;
    @Field(type = FieldType.Text)
    private String autor;
    @Field(type = FieldType.Integer)
    private String cantidadPaginas;
    @Field(type = FieldType.Text)
    private String editorial;
    @Field(type = FieldType.Integer)
    private String anioPrimeraPublicacion;
}
