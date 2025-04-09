package com.blog.blog.repository;

import com.blog.blog.dto.EntradaBlogDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository{
    private List<EntradaBlogDTO> listaBlog = new ArrayList<>();

    @Override
    @PostConstruct
    public void init() {
        EntradaBlogDTO e1 = new EntradaBlogDTO(1,"aa","aa", LocalDate.of(2025,05,05));
        EntradaBlogDTO e2 = new EntradaBlogDTO(2,"bb","bb", LocalDate.of(2023,05,05));
        EntradaBlogDTO e3 = new EntradaBlogDTO(3,"cc","cc", LocalDate.of(2020,05,05));
        EntradaBlogDTO e4 = new EntradaBlogDTO(4,"dd","dd", LocalDate.of(2019,05,05));
        EntradaBlogDTO e5 = new EntradaBlogDTO(5,"ee","ee", LocalDate.of(2014,05,05));

        listaBlog.add(e1);
        listaBlog.add(e2);
        listaBlog.add(e3);
        listaBlog.add(e4);
        listaBlog.add(e5);
    }

    @Override
    public List<EntradaBlogDTO> getAllEntradaBlog() {
        return listaBlog;
    }

    @Override
    public void addEntradaBlog(EntradaBlogDTO e) {
        listaBlog.add(e);
    }
}
