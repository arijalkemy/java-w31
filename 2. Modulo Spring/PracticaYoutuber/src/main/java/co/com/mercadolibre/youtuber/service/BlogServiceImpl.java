package co.com.mercadolibre.youtuber.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.mercadolibre.youtuber.dto.EntradaBlogDto;
import co.com.mercadolibre.youtuber.exception.BlogNotFoundException;
import co.com.mercadolibre.youtuber.mapper.EntradaBlogMapper;
import co.com.mercadolibre.youtuber.model.EntradaBlog;
import co.com.mercadolibre.youtuber.repository.BlogRepository;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public EntradaBlogDto createBlogEntry(EntradaBlogDto entradaBlogDto) {
        EntradaBlog entity = EntradaBlogMapper.toEntity(entradaBlogDto);
        blogRepository.save(entity);
        return EntradaBlogMapper.toDto(entity);
    }

    @Override
    public EntradaBlogDto getBlogEntry(Long id) {
        EntradaBlog blog = blogRepository.findById(id)
            .orElseThrow(() -> new BlogNotFoundException("No se encontró la entrada de blog con el Id dado"));
        return EntradaBlogMapper.toDto(blog);
    }

    @Override
    public List<EntradaBlogDto> getAllBlogEntries() {
        return blogRepository.findAll().stream()
                .map(EntradaBlogMapper::toDto)
                .collect(Collectors.toList());
    }
}
