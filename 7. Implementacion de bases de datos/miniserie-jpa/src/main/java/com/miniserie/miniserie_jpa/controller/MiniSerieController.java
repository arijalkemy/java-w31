package com.miniserie.miniserie_jpa.controller;

import com.miniserie.miniserie_jpa.dto.MiniSerieDto;
import com.miniserie.miniserie_jpa.service.IMiniSerieService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/miniseries")
public class MiniSerieController {
    private final IMiniSerieService miniSerieService;

    @GetMapping("/getAll")
    public ResponseEntity<List<MiniSerieDto>> getAllMiniSeries(){
        return new ResponseEntity<>(miniSerieService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MiniSerieDto> addMiniserie(@RequestBody MiniSerieDto miniSerieDto){
        return new ResponseEntity<>(miniSerieService.addMiniserie(miniSerieDto), HttpStatus.OK);
    }

    @PutMapping("/update/{idMiniSerie}")
    public ResponseEntity<MiniSerieDto> updateMiniSerie(@PathVariable Long idMiniSerie,@RequestBody MiniSerieDto miniSerieDto){
        return new ResponseEntity<>(miniSerieService.updateMiniSerie(idMiniSerie, miniSerieDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idMiniSerie}")
    public ResponseEntity<String> deleteMiniSerie(@PathVariable Long idMiniSerie){
        miniSerieService.deleteMiniSerie(idMiniSerie);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @GetMapping("/get/{idMiniSerie}")
    public ResponseEntity<MiniSerieDto> getMiniSerie(@PathVariable Long idMiniSerie){
        return new ResponseEntity<>(miniSerieService.getMiniSerie(idMiniSerie), HttpStatus.OK);
    }
}
