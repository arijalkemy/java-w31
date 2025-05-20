package com.bootcamp.obrasliterarias_nosql.service;

import com.bootcamp.obrasliterarias_nosql.dto.LiteraryWorkDTO;
import com.bootcamp.obrasliterarias_nosql.mapper.LiteraryWorkMapper;
import com.bootcamp.obrasliterarias_nosql.model.LiteraryWork;
import com.bootcamp.obrasliterarias_nosql.repository.LiteraryWorkRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class LiteraryWorkService {
    private final LiteraryWorkRepository repository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;

    @Autowired
    public LiteraryWorkService(LiteraryWorkRepository repository){
        this.repository = repository;
    }

    public LiteraryWorkDTO newLiteraryWork(LiteraryWorkDTO dto){
        LiteraryWork work = LiteraryWorkMapper.toEntity(dto);
        LiteraryWork save = repository.save(work);
        return LiteraryWorkMapper.toDTO(save);
    }

    public List<LiteraryWorkDTO> findByAuthor(String author){
        List<LiteraryWork> work = repository.findByAuthor(author);
        return LiteraryWorkMapper.toDTOList(work);
    }

    public List<LiteraryWorkDTO> findByKeywordInTitle(String keyword){
        List<LiteraryWork> work = repository.findByKeywordInTitle(keyword);
        return LiteraryWorkMapper.toDTOList(work);
    }

    public List<LiteraryWorkDTO> getTop5ByPageCount(){
        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(org.elasticsearch.index.query.QueryBuilders.matchAllQuery())
                .withSort(SortBuilders.fieldSort("numberPages").order(SortOrder.DESC))
                .build();
        query.setPageable(PageRequest.of(0, 5));

        List<LiteraryWork> result = elasticsearchTemplate
                .search(query, LiteraryWork.class)
                .stream()
                .map(SearchHit::getContent)
                .toList();

        return LiteraryWorkMapper.toDTOList(result);
    }

    public List<LiteraryWorkDTO> getByYearBefore(int year){
        Query query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.rangeQuery("year").lt(year))
                .build();

        List<LiteraryWork> result = elasticsearchTemplate
                .search(query, LiteraryWork.class)
                .stream()
                .map(SearchHit::getContent)
                .toList();

        return LiteraryWorkMapper.toDTOList(result);
    }

    public List<LiteraryWorkDTO> findByEditorial(String editorial){
        List<LiteraryWork> work = repository.findByEditorial(editorial);
        return LiteraryWorkMapper.toDTOList(work);
    }


}




