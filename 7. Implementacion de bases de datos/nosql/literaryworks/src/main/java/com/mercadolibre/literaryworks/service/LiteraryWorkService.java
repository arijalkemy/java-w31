package com.mercadolibre.literaryworks.service;

import com.mercadolibre.literaryworks.dto.LiteraryWorkDTO;
import com.mercadolibre.literaryworks.model.LiteraryWork;
import com.mercadolibre.literaryworks.repository.LiteraryWorkRepository;
import com.mercadolibre.literaryworks.util.GenericObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteraryWorkService implements ILiteraryWorkService {

    @Autowired
    private LiteraryWorkRepository literaryWorkRepository;
    @Autowired
    private GenericObjectMapper mapper;


    @Override
    public List<LiteraryWorkDTO> findAll() {
        return mapper.mapList(literaryWorkRepository.findAll(), LiteraryWorkDTO.class);
    }

    @Override
    public LiteraryWorkDTO add(LiteraryWorkDTO lw) {
        LiteraryWork newLw = mapper.map(lw, LiteraryWork.class);
        literaryWorkRepository.save(newLw);
        return mapper.map(newLw, LiteraryWorkDTO.class);
    }

    @Override
    public List<LiteraryWorkDTO> addAll(List<LiteraryWork> batch) {
        return mapper.mapList((List<LiteraryWork>) literaryWorkRepository.saveAll(batch), LiteraryWorkDTO.class);
    }

    @Override
    public void delete(String id) {
        if (!literaryWorkRepository.existsById(id)) {
            throw new org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.NOT_FOUND, "No document found with id: " + id);
        }

        literaryWorkRepository.deleteById(id);
    }

    @Override
    public List<LiteraryWorkDTO> findByAuthor(String name) {
        return mapper.mapList(literaryWorkRepository.findByAuthor(name), LiteraryWorkDTO.class);
    }

    @Override
    public List<LiteraryWorkDTO> findByKeyword(String keyword) {
        return mapper.mapList(literaryWorkRepository.findByTitle(keyword), LiteraryWorkDTO.class);
    }

    @Override
    public List<LiteraryWorkDTO> getTopFiveWithMostPages() {
        List<LiteraryWork> topFive = literaryWorkRepository
                .findAllByOrderByNumberOfPagesDesc(PageRequest.of(0, 5));
        return mapper.mapList(topFive, LiteraryWorkDTO.class);
    }

    @Override
    public List<LiteraryWorkDTO> getPublishedBeforeYear(int year) {
        return mapper.mapList(literaryWorkRepository.findByPublishYearBefore(year), LiteraryWorkDTO.class);
    }

    @Override
    public List<LiteraryWorkDTO> findByPublisher(String publisher) {
        return mapper.mapList(literaryWorkRepository.findByPublisher(publisher), LiteraryWorkDTO.class);
    }
}
