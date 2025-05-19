package com.mercadolibre.testcases.service;

import com.mercadolibre.testcases.dto.TesterDto;
import com.mercadolibre.testcases.model.Tester;
import com.mercadolibre.testcases.repository.ITesterRepository;
import com.mercadolibre.testcases.util.TesterMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TesterServiceImpl implements ITesterService {
    private final ITesterRepository testerRepository;

    public TesterServiceImpl(ITesterRepository testerRepository) {
        this.testerRepository = testerRepository;
    }

    @Override
    public TesterDto save(TesterDto testerDto) {
        Tester tester = testerRepository.save(TesterMapper.toTester(testerDto));
        return TesterMapper.toTesterDto(tester);
    }

    @Override
    public List<TesterDto> getAll() {
        return testerRepository.findAll().stream().map(TesterMapper::toTesterDto).toList();
    }
}
