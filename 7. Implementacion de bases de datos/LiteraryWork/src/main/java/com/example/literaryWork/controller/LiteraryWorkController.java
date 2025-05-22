package com.example.literaryWork.controller;

import com.example.literaryWork.model.Article;
import com.example.literaryWork.model.LiteraryWork;
import com.example.literaryWork.service.ILiteraryWorkService;
import com.example.literaryWork.service.ImpLiteraryWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/literaryworks")
public class LiteraryWorkController {

    @Autowired
    private ImpLiteraryWorkService service;

    @PostMapping("/new")
    public LiteraryWork save(@RequestBody LiteraryWork work) {
        return service.save(work);
    }

    @GetMapping
    public List<LiteraryWork> findAll() {
        return service.findAll();
    }

    @GetMapping("/author/{author}")
    public List<LiteraryWork> findByAuthor(@PathVariable String author) {
        return service.findByAuthor(author);
    }

    @GetMapping("/keyword/{keyword}")
    public List<LiteraryWork> findByTitleKeyword(@PathVariable String keyword) {
        return service.findByTitleKeyword(keyword);
    }

    @GetMapping("/top5pages")
    public List<LiteraryWork> findTop5ByPages() {
        return service.findTop5ByPages();
    }

    @GetMapping("/year/{year}")
    public List<LiteraryWork> findByYearPublishedBefore(@PathVariable int year) {
        return service.findByYearPublishedBefore(year);
    }

    @GetMapping("/publisher/{publisher}")
    public List<LiteraryWork> findByPublisher(@PathVariable String publisher) {
        return service.findByPublisher(publisher);
    }

}
