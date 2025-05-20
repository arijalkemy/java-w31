package co.com.mercadolibre.practicaobrasliterarias.controller;

import co.com.mercadolibre.practicaobrasliterarias.dto.LiteraryWorkDto;
import co.com.mercadolibre.practicaobrasliterarias.service.ILiterallyWorkService;
import co.elastic.clients.elasticsearch.ml.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/literay")
public class LiteraryWorkController {

    private final ILiterallyWorkService literallyWorkService;

    @PostMapping("/create")
    public ResponseEntity<Void> post(@RequestBody LiteraryWorkDto literaryWorkDto) {
        this.literallyWorkService.save(literaryWorkDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/author/{by_author}")
    public ResponseEntity<List<LiteraryWorkDto>> findByAuthor(@PathVariable String by_author) {
        return ResponseEntity.ok().body(this.literallyWorkService.findByAuthor(by_author));

    }
    @GetMapping("/titulo/by_title")
    public ResponseEntity<List<LiteraryWorkDto>> findByTitle(@RequestParam(required = true) String title) {
        return ResponseEntity.ok().body(this.literallyWorkService.findByTitle(title));
    }
    @GetMapping("/conteo/by_page_count")
    public ResponseEntity<List<LiteraryWorkDto>> findAllByOrderByPageCountDesc() {
        return ResponseEntity.ok().body(this.literallyWorkService.
                findAllByOrderByPageCountDesc(PageRequest.of(0, 5)));
    }
    @GetMapping("/year/{by_first_publication_year}")
    public ResponseEntity<List<LiteraryWorkDto>>  findByFirstPublicationYearLessThan(
            @PathVariable(value = "by_first_publication_year" ) int year) {
        return ResponseEntity.ok().body(this.literallyWorkService.findByFirstPublicationYearLessThan(year));
    }
    @GetMapping("/publisher/{by_publisher}")
    public ResponseEntity<List<LiteraryWorkDto>> findByPublisher(@PathVariable(value = "by_publisher") String publisher) {
        return ResponseEntity.ok().body(this.literallyWorkService.findByPublisher(publisher));
    }

}
