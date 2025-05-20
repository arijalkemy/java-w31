package co.com.mercadolibre.practicaobrasliterarias.mapper;

import co.com.mercadolibre.practicaobrasliterarias.dto.LiteraryWorkDto;
import co.com.mercadolibre.practicaobrasliterarias.model.LiteraryWork;

public class LiteraryWorkMapper {

    public static LiteraryWork toEntity(LiteraryWorkDto literaryWorkDto){
        return LiteraryWork.builder()
                .id(literaryWorkDto.getId())
                .title(literaryWorkDto.getTitle())
                .author(literaryWorkDto.getAuthor())
                .pageCount(literaryWorkDto.getPageCount())
                .publisher(literaryWorkDto.getPublisher())
                .firstPublicationYear(literaryWorkDto.getFirstPublicationYear())
                .build();
    }

    public static LiteraryWorkDto toDto(LiteraryWork literaryWork){
        return LiteraryWorkDto.builder()
                .id(literaryWork.getId())
                .title(literaryWork.getTitle())
                .author(literaryWork.getAuthor())
                .pageCount(literaryWork.getPageCount())
                .publisher(literaryWork.getPublisher())
                .firstPublicationYear(literaryWork.getFirstPublicationYear())
                .build();
    }
}
