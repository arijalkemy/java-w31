package com.qa_tester.ejercicio_qa.service.implementation;

import com.qa_tester.ejercicio_qa.dto.TesterDto;
import com.qa_tester.ejercicio_qa.exception.BadRequest;
import com.qa_tester.ejercicio_qa.model.Tester;
import com.qa_tester.ejercicio_qa.repository.TesterRepository;
import com.qa_tester.ejercicio_qa.service.ITesterService;
import com.qa_tester.ejercicio_qa.utils.GlobalMapping;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TesterService implements ITesterService {
    private final TesterRepository testerRepository;

    @Override
    public TesterDto addTester(TesterDto testerDto){
        if(testerRepository.existsByNameAndSeniority(testerDto.getName(), testerDto.getSeniority())){
            throw new BadRequest("Already exist a tester with that data");
        }

        Tester tester = GlobalMapping.dtoToEntityTester(testerDto);
        testerRepository.save(tester);
        return GlobalMapping.entityToDtoTester(tester);
    }

    @Override
    public List<TesterDto> getAllTester(){
        List<Tester> testerList = testerRepository.findAll();
        if (testerList.isEmpty()){
            throw new BadRequest("No tester found");
        }
        return GlobalMapping.entityToDtoListTester(testerList);
    }

    @Override
    public TesterDto findById(Long id){
        Tester testerDb = testerRepository.findById(id)
                .orElseThrow(()-> new BadRequest("No tester found"));
        return GlobalMapping.entityToDtoTester(testerDb);
    }

}
