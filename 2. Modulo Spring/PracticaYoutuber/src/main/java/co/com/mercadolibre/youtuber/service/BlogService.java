package co.com.mercadolibre.youtuber.service;

import java.util.List;

import co.com.mercadolibre.youtuber.dto.EntradaBlogDto;

public interface BlogService {
    EntradaBlogDto createBlogEntry(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto getBlogEntry(Long id);
    List<EntradaBlogDto> getAllBlogEntries();
}
