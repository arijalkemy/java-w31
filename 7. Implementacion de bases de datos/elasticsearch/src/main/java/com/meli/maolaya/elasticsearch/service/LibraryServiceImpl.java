package com.meli.maolaya.elasticsearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.maolaya.elasticsearch.domain.LiteraryWork;
import com.meli.maolaya.elasticsearch.dto.LiteraryWorkDto;
import com.meli.maolaya.elasticsearch.repository.ILibraryRepository;

@Service
public class LibraryServiceImpl implements ILibraryService {

    private ILibraryRepository libraryRepository;

    public LibraryServiceImpl(ILibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public List<LiteraryWorkDto> getByAuthor(String author) {
        List<LiteraryWork> lwsByAuthor = libraryRepository.findByAuthorIgnoreCase(author);
        return lwsByAuthor.stream().map(lw -> LiteraryWorkDto.fromEntity(lw)).toList();
    }

    @Override
    public List<LiteraryWorkDto> getByTitle(String title) {
        List<LiteraryWork> lwsByAuthor = libraryRepository.findByNameContains(title);
        return lwsByAuthor.stream().map(lw -> LiteraryWorkDto.fromEntity(lw)).toList();
    }

    @Override
    public List<LiteraryWorkDto> getByPages() {
        List<LiteraryWork> lwsByAuthor = libraryRepository.findTop5ByOrderByPagesDesc();
        return lwsByAuthor.stream().map(lw -> LiteraryWorkDto.fromEntity(lw)).toList();
    }

    @Override
    public List<LiteraryWorkDto> getBeforeYear(Integer year) {
        List<LiteraryWork> lwsByAuthor = libraryRepository.findByPublicationYearLessThan(year);
        return lwsByAuthor.stream().map(lw -> LiteraryWorkDto.fromEntity(lw)).toList();
    }

    @Override
    public List<LiteraryWorkDto> getByEditorial(String editorial) {
        List<LiteraryWork> lwsByAuthor = libraryRepository.findByEditorial(editorial);
        return lwsByAuthor.stream().map(lw -> LiteraryWorkDto.fromEntity(lw)).toList();
    }

}
