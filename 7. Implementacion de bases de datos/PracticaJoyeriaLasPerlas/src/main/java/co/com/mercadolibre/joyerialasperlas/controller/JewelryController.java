package co.com.mercadolibre.joyerialasperlas.controller;

import co.com.mercadolibre.joyerialasperlas.dto.JewelryDto;
import co.com.mercadolibre.joyerialasperlas.service.IJewelryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
@RequiredArgsConstructor
public class JewelryController {

    private final IJewelryService jewelryService;

    @GetMapping
    public ResponseEntity<List<JewelryDto>> getAll(){
        return ResponseEntity.ok().body(jewelryService.getAll());
    }

    @PostMapping("/new")
    public ResponseEntity<JewelryDto> create(@RequestBody JewelryDto jewelryDto){
        jewelryService.save(jewelryDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<JewelryDto> update (@RequestBody JewelryDto jewelryDto,
                                              @PathVariable(value = "id_modificar") Long id){
        jewelryService.update(jewelryDto, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        return ResponseEntity.noContent().build();
    }
}
