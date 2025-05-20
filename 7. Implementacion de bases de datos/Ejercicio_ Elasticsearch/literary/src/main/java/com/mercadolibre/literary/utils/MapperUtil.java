package com.mercadolibre.literary.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.literary.dto.BookDto;
import com.mercadolibre.literary.model.Book;

public class MapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static BookDto toDto(Book book) {
        if (book == null) return null;
        return objectMapper.convertValue(book, BookDto.class);
    }

    public static Book toEntity(BookDto dto) {
        if (dto == null) return null;
        return objectMapper.convertValue(dto, Book.class);
    }
}
