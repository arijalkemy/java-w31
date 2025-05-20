package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.dto.LiteraryWorkDTO;
import com.mercadolibre.obrasliterarias.model.LiteraryWork;
import com.mercadolibre.obrasliterarias.repository.ILiteraryWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LiteraryWorkService {

    private final ILiteraryWorkRepository repository;

    public LiteraryWork save(LiteraryWorkDTO dto) {
        LiteraryWork work = LiteraryWork.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .pages(dto.getPages())
                .publisher(dto.getPublisher())
                .year(dto.getYear())
                .build();
        return repository.save(work);
    }

    public List<LiteraryWork> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<LiteraryWork> findByKeyword(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<LiteraryWork> findTop5ByPages() {
        Pageable topFive = PageRequest.of(0, 5);
        return repository.findTop5ByOrderByPagesDesc(topFive);
    }

    public List<LiteraryWork> findBeforeYear(int year) {
        return repository.findByYearLessThan(year);
    }

    public List<LiteraryWork> findByPublisher(String publisher) {
        return repository.findByPublisher(publisher);
    }
}

