package co.com.mercadolibre.practicaobrasliterarias.service;

import co.com.mercadolibre.practicaobrasliterarias.dto.LiteraryWorkDto;
import co.com.mercadolibre.practicaobrasliterarias.mapper.LiteraryWorkMapper;
import co.com.mercadolibre.practicaobrasliterarias.repository.LiteraryWorkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LiterallyWorkServiceImpl implements ILiterallyWorkService{

    private final LiteraryWorkRepository literaryWorkRepository;

    @Override
    public void save(LiteraryWorkDto literaryWorkDto) {
        literaryWorkRepository.save(LiteraryWorkMapper.toEntity(literaryWorkDto));
    }

    @Override
    public List<LiteraryWorkDto> findByAuthor(String author) {
        return literaryWorkRepository.findByAuthor(author).stream()
                .map(LiteraryWorkMapper::toDto).toList();
    }

    @Override
    public List<LiteraryWorkDto> findByTitle(String title) {
        return literaryWorkRepository.findByTitle(title).stream()
                .map(LiteraryWorkMapper::toDto).toList();
    }

    @Override
    public List<LiteraryWorkDto> findAllByOrderByPageCountDesc(Pageable pageable) {
        return literaryWorkRepository.findAllByOrderByPageCountDesc(PageRequest.of(0, 5))
                .stream().map(LiteraryWorkMapper::toDto).toList();
    }

    @Override
    public List<LiteraryWorkDto> findByFirstPublicationYearLessThan(int firstPublicationYear) {
        return literaryWorkRepository.findByFirstPublicationYearLessThan(2024).stream()
                .map(LiteraryWorkMapper::toDto).toList();
    }

    @Override
    public List<LiteraryWorkDto> findByPublisher(String publisher) {
        return literaryWorkRepository.findByPublisher(publisher).stream()
                .map(LiteraryWorkMapper::toDto).toList();
    }
}
