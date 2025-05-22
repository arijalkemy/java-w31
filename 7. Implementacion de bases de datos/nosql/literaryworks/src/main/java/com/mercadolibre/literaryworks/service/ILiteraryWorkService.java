package com.mercadolibre.literaryworks.service;

import com.mercadolibre.literaryworks.dto.LiteraryWorkDTO;
import com.mercadolibre.literaryworks.model.LiteraryWork;

import java.util.List;

public interface ILiteraryWorkService {
    List<LiteraryWorkDTO> findAll();

    LiteraryWorkDTO add(LiteraryWorkDTO lw);

    List<LiteraryWorkDTO> addAll(List<LiteraryWork> batch);

    void delete(String id);

    List<LiteraryWorkDTO> findByAuthor(String name);

    List<LiteraryWorkDTO> findByKeyword(String keyword);

    List<LiteraryWorkDTO> getTopFiveWithMostPages();

    List<LiteraryWorkDTO> getPublishedBeforeYear(int year);

    List<LiteraryWorkDTO> findByPublisher(String editorial);
}
