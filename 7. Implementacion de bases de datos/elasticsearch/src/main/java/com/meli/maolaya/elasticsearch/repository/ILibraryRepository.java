package com.meli.maolaya.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.meli.maolaya.elasticsearch.domain.LiteraryWork;
import java.util.List;

@Repository
public interface ILibraryRepository extends ElasticsearchRepository<LiteraryWork, String> {
    List<LiteraryWork> findByAuthorIgnoreCase(String author);

    List<LiteraryWork> findByNameContains(String title);

    List<LiteraryWork> findTop5ByOrderByPagesDesc();

    List<LiteraryWork> findByPublicationYearLessThan(Integer year);

    List<LiteraryWork> findByEditorial(String editorial);
}
