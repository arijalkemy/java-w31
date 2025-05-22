package com.mercadolibre.literaryworks.repository;

import com.mercadolibre.literaryworks.model.LiteraryWork;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {

    List<LiteraryWork> findAll();

    List<LiteraryWork> findByAuthor(String name);

    List<LiteraryWork> findByTitle(String title);

    List<LiteraryWork> findAllByOrderByNumberOfPagesDesc(Pageable pageable);

    List<LiteraryWork> findByPublishYearBefore(Integer publishYearBefore);

    List<LiteraryWork> findByPublisher(String publisher);
}
