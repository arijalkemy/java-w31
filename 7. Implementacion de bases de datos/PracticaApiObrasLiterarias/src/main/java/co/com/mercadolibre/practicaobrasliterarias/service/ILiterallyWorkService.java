package co.com.mercadolibre.practicaobrasliterarias.service;

import co.com.mercadolibre.practicaobrasliterarias.dto.LiteraryWorkDto;
import co.com.mercadolibre.practicaobrasliterarias.model.LiteraryWork;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILiterallyWorkService {

    void save(LiteraryWorkDto literaryWorkDto);
    List<LiteraryWorkDto> findByAuthor(String author);
    List<LiteraryWorkDto> findByTitle(String title);
    List<LiteraryWorkDto> findAllByOrderByPageCountDesc(Pageable pageable);
    List<LiteraryWorkDto> findByFirstPublicationYearLessThan(int firstPublicationYear);
    List<LiteraryWorkDto> findByPublisher(String publisher);

}
