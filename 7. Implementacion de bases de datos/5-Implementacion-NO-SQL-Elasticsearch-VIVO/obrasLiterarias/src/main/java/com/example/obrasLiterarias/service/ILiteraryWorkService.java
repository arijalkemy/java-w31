package com.example.obrasLiterarias.service;

import java.util.List;

import com.example.obrasLiterarias.model.LiteraryWork;

public interface ILiteraryWorkService {
    List<LiteraryWork> postABatchOfLiteraryWork(List<LiteraryWork> batch);
    List<LiteraryWork> getLiteraryWorksByAuthor(String name);
    List<LiteraryWork> getAllLiteraryWork();
    List<LiteraryWork> getLiteraryWorkByKeyWord(String keyword);
    List<LiteraryWork> getTopFiveLongestLiteraryWork();
    List<LiteraryWork> getLiteraryWorkByYear(int year);
    List<LiteraryWork> getLiteraryWorkByPublisher(String publisher);
}
