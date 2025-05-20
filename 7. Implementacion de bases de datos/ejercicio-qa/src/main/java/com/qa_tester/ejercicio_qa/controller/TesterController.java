package com.qa_tester.ejercicio_qa.controller;

import com.qa_tester.ejercicio_qa.dto.TesterDto;
import com.qa_tester.ejercicio_qa.service.ITesterService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/tester")
public class TesterController {
    private final ITesterService testerService;

    @PostMapping("/new")
    public ResponseEntity<TesterDto> addTester(@RequestBody TesterDto testerDto){
        return ResponseEntity.ok(testerService.addTester(testerDto));
    }

    @GetMapping("/get")
    public ResponseEntity<List<TesterDto>> getTesters(){
        return ResponseEntity.ok(testerService.getAllTester());
    }


}
