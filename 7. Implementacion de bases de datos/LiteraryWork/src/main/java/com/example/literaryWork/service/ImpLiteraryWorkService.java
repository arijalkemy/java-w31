package com.example.literaryWork.service;

import com.example.literaryWork.model.LiteraryWork;
import com.example.literaryWork.repository.LiteraryWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpLiteraryWorkService implements ILiteraryWorkService {

    @Autowired
    private LiteraryWorkRepository repository;

    public LiteraryWork save(LiteraryWork work) {
        return repository.save(work);
    }

    public List<LiteraryWork> findAll() {
        Page<LiteraryWork> page = repository.findAll(PageRequest.of(0, 100)); // Define el tamaño máximo que esperas recibir
        return page.getContent();
    }

    public List<LiteraryWork> findByAuthor(String author) {
        return repository.findByAuthor(author);
    }

    public List<LiteraryWork> findByTitleKeyword(String keyword) {
        return repository.findByNameContaining(keyword);
    }

    public List<LiteraryWork> findTop5ByPages() {
        List<LiteraryWork> works = new ArrayList<>();
        repository.findAll().forEach(works::add);
        return works.stream()
                .sorted((w1, w2) -> Integer.compare(w2.getPages(), w1.getPages()))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<LiteraryWork> findByYearPublishedBefore(int year) {
        return repository.findByYearPublishedBefore(year);
    }

    public List<LiteraryWork> findByPublisher(String publisher) {
        return repository.findByPublisher(publisher);
    }
}
