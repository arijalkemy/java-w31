package com.example.obrasLiterarias.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.example.obrasLiterarias.model.LiteraryWork;
import com.example.obrasLiterarias.repository.ILiteraryWorkRepository;

@Service
public class ImpleLiteraryWorkService implements ILiteraryWorkService{
    
    private ILiteraryWorkRepository literaryWorkRepository;

    public ImpleLiteraryWorkService(ILiteraryWorkRepository literaryWorkRepository) {
        this.literaryWorkRepository = literaryWorkRepository;
    }

    @Override
    public List<LiteraryWork> postABatchOfLiteraryWork(List<LiteraryWork> batch){
        for (LiteraryWork literaryWork : batch){
            literaryWorkRepository.save(literaryWork);
        }
        return batch;
    }

    @Override
    public List<LiteraryWork> getLiteraryWorksByAuthor(String name){
        return literaryWorkRepository.findByAuthor(name);
    }

    @Override
    public List<LiteraryWork> getAllLiteraryWork(){
        Iterable<LiteraryWork> iterableFindAll = literaryWorkRepository.findAll();
        List<LiteraryWork> listFindAll = StreamSupport
            .stream(iterableFindAll.spliterator(), false)
            .collect(Collectors.toList());
        return listFindAll;
    }

    public List<LiteraryWork> getLiteraryWorkByKeyWord(String keyword){
        return literaryWorkRepository.findByKeyWord(keyword);
    }

    public List<LiteraryWork> getTopFiveLongestLiteraryWork(){
        return literaryWorkRepository.findTop3ByOrderByNumberOfPagesDesc();
    }

    public List<LiteraryWork> getLiteraryWorkByYear(int year){
        return literaryWorkRepository.findWorksPublishedBefore(year);
    }

    public List<LiteraryWork> getLiteraryWorkByPublisher(String publisher){
        return literaryWorkRepository.findWorksByPublisher(publisher);
    }

}
