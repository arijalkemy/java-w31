package co.com.mercadolibre.youtuber.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.youtuber.dto.EntradaBlogDto;
import co.com.mercadolibre.youtuber.service.BlogService;


@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping    
    public ResponseEntity<String> createBlogEntry(@RequestBody EntradaBlogDto entradaBlogDto) {
        blogService.createBlogEntry(entradaBlogDto);
        return ResponseEntity.ok("Entrada de Blog creada correctamente con el id dado");
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaBlogDto> getBlogEntry(@PathVariable Long id) {
        EntradaBlogDto entrada = blogService.getBlogEntry(id);
        return ResponseEntity.ok(entrada);
    }

    @GetMapping
    public ResponseEntity<List<EntradaBlogDto>> getAllBlogEntries() {
        List<EntradaBlogDto> entradas = blogService.getAllBlogEntries();
        return ResponseEntity.ok(entradas);
    }
}
