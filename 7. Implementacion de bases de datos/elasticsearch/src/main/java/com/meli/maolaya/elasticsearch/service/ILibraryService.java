package com.meli.maolaya.elasticsearch.service;

import java.util.List;

import com.meli.maolaya.elasticsearch.dto.LiteraryWorkDto;

public interface ILibraryService {

    List<LiteraryWorkDto> getByAuthor(String author);

    List<LiteraryWorkDto> getByTitle(String title);

    List<LiteraryWorkDto> getByPages();

    List<LiteraryWorkDto> getBeforeYear(Integer year);

    List<LiteraryWorkDto> getByEditorial(String editorial);

}
