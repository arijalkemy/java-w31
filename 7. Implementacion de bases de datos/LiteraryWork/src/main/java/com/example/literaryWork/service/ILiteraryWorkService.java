package com.example.literaryWork.service;

import com.example.literaryWork.model.Article;
import com.example.literaryWork.model.LiteraryWork;

import java.util.List;
import java.util.Optional;

public interface ILiteraryWorkService {

    public LiteraryWork save(LiteraryWork work);

    public List<LiteraryWork> findAll();

    public List<LiteraryWork> findByAuthor(String author);

    public List<LiteraryWork> findByTitleKeyword(String keyword);

    public List<LiteraryWork> findTop5ByPages();

    public List<LiteraryWork> findByYearPublishedBefore(int year);

    public List<LiteraryWork> findByPublisher(String publisher);
}
