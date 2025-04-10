package com.blog.blog.repository;

import com.blog.blog.model.EntradaBlog;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {
    private List<EntradaBlog> listaBlog = new ArrayList<>();
    private AtomicInteger idContador = new AtomicInteger(0);

    @Override
    @PostConstruct
    public void init() {
        EntradaBlog e1 = new EntradaBlog("aa","aa", LocalDate.of(2025,05,05));
        save(e1);
        EntradaBlog e2 = new EntradaBlog("bb","bb", LocalDate.of(2000,05,05));
        save(e2);
        EntradaBlog e3 = new EntradaBlog("cc","cc", LocalDate.of(1994,05,05));
        save(e3);
    }

    @Override
    public List<EntradaBlog> getAllEntradaBlog() {
        return listaBlog;
    }

    @Override
    public void save(EntradaBlog e) {
        e.setId(idContador.incrementAndGet());
        listaBlog.add(e);
    }

    @Override
    public EntradaBlog findById(Integer id) {
        return listaBlog.stream()
                .filter(a-> a.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
