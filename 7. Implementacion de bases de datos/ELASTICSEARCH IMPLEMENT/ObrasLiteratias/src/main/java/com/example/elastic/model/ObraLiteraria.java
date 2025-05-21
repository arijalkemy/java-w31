package com.example.elastic.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "obras_literarias")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ObraLiteraria {
    @Id
    private Integer id;
    private String name;
    private String author;
    private Integer countPage;
    private String editorial;
    private Integer yearPublication;

}
