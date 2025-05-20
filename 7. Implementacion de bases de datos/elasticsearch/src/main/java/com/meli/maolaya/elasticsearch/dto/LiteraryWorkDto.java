package com.meli.maolaya.elasticsearch.dto;

import java.io.Serializable;

import com.meli.maolaya.elasticsearch.domain.LiteraryWork;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiteraryWorkDto implements Serializable {
    private String id;
    private String name;
    private String author;
    private Integer pages;
    private String editorial;
    private Integer publicationYear;

    public static LiteraryWorkDto fromEntity(LiteraryWork literaryWork) {
        LiteraryWorkDto dto = new LiteraryWorkDto();
        dto.setId(literaryWork.getId());
        dto.setName(literaryWork.getName());
        dto.setAuthor(literaryWork.getAuthor());
        dto.setPages(literaryWork.getPages());
        dto.setEditorial(literaryWork.getEditorial());
        dto.setPublicationYear(literaryWork.getPublicationYear());
        return dto;
    }

    public LiteraryWork toEntity() {
        LiteraryWork literaryWork = new LiteraryWork();
        literaryWork.setAuthor(this.getAuthor());
        literaryWork.setName(this.getName());
        literaryWork.setPages(this.getPages());
        literaryWork.setEditorial(this.getEditorial());
        literaryWork.setPublicationYear(this.getPublicationYear());
        return literaryWork;
    }
}
