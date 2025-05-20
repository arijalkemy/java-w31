package co.com.mercadolibre.practicaqatesters.controller;

import co.com.mercadolibre.practicaqatesters.dto.TestCaseDto;
import co.com.mercadolibre.practicaqatesters.service.ITestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
@RequiredArgsConstructor
public class TestCaseController {

    private final ITestCaseService testCaseService;

    @GetMapping
    ResponseEntity<List<TestCaseDto>> getAll(){
        return ResponseEntity.ok().body(testCaseService.getAll());
    }

    @PostMapping("/new")
    ResponseEntity<Void> save(@RequestBody TestCaseDto testCaseDto){
        testCaseService.save(testCaseDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    ResponseEntity<Void> update (@RequestBody TestCaseDto testCaseDto, @PathVariable Long id){
        testCaseService.update(testCaseDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    ResponseEntity<TestCaseDto> getById(@PathVariable Long id){
        return ResponseEntity.ok().body(testCaseService.getById(id));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){
        testCaseService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{last_update}")
    ResponseEntity<List<TestCaseDto>> getByLastUpdate (@PathVariable(value = "last_update") String lastUpdate){
        return  ResponseEntity.ok().body(testCaseService.getAllByLastUpdate(LocalDate.parse(lastUpdate)));
    }



}
