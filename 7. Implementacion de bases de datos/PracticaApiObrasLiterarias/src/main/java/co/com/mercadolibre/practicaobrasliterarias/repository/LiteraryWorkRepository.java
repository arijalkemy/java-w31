package co.com.mercadolibre.practicaobrasliterarias.repository;

import co.com.mercadolibre.practicaobrasliterarias.dto.LiteraryWorkDto;
import co.com.mercadolibre.practicaobrasliterarias.model.LiteraryWork;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LiteraryWorkRepository extends ElasticsearchRepository<LiteraryWork, String> {

    List<LiteraryWork> findByAuthor(String author);
    List<LiteraryWork> findByTitle(String title);
    List<LiteraryWork> findAllByOrderByPageCountDesc(Pageable pageable);
    List<LiteraryWork> findByFirstPublicationYearLessThan(int firstPublicationYear);
    List<LiteraryWork> findByPublisher(String publisher);
}
