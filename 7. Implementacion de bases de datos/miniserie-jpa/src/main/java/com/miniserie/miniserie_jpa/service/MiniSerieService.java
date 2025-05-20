package com.miniserie.miniserie_jpa.service;

import com.miniserie.miniserie_jpa.dto.MiniSerieDto;
import com.miniserie.miniserie_jpa.exception.BadRequest;
import com.miniserie.miniserie_jpa.model.MiniSerie;
import com.miniserie.miniserie_jpa.repository.MiniSerieRepository;
import com.miniserie.miniserie_jpa.utils.GlobalMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MiniSerieService implements IMiniSerieService{
    private final MiniSerieRepository miniSerieRepository;

    @Override
    public List<MiniSerieDto> getAll(){
        List<MiniSerie> miniSerieList = miniSerieRepository.findAll();
        if(miniSerieList.isEmpty()){
            throw new BadRequest("Miniseries not found");
        }
        return GlobalMapper.miniSerieToDtoList(miniSerieList);
    }

    @Override
    public MiniSerieDto addMiniserie(MiniSerieDto miniSerieDto){
        MiniSerie miniSerie = GlobalMapper.dtoToEntity(miniSerieDto);
        if(miniSerieRepository.findAll().stream()
                .anyMatch(x -> x.getName().equals(miniSerie.getName()))){
            throw new BadRequest("Already exist a miniserie with that name");
        }

        miniSerieRepository.save(miniSerie);
        return GlobalMapper.entityToDto(miniSerie);
    }

    @Override
    public MiniSerieDto updateMiniSerie(Long id, MiniSerieDto miniSerieDto){
        List<MiniSerie> miniSerieDb = miniSerieRepository.findAll();
        if(miniSerieDb.stream()
                .anyMatch(miniSerie -> miniSerie.getName().equals(miniSerieDto.getName()))){
            throw new BadRequest("Already exist a miniserie with that name");
        }

        MiniSerie miniSerieToUpdate = miniSerieRepository.findById(id)
                .orElseThrow(()-> new BadRequest("No miniserie has this id"));

        miniSerieToUpdate.setName(miniSerieDto.getName());
        miniSerieToUpdate.setRating(miniSerieDto.getRating());
        miniSerieToUpdate.setAmountOfAwards(miniSerieDto.getAmountOfAwards());

        miniSerieRepository.save(miniSerieToUpdate);
        return GlobalMapper.entityToDto(miniSerieToUpdate);
    }

    @Override
    public void deleteMiniSerie(Long id){
       MiniSerie miniSeriedb = miniSerieRepository.findById(id)
                .orElseThrow(()->new BadRequest("No miniserie has this id"));

        miniSerieRepository.deleteById(miniSeriedb.getId());
    }

    @Override
    public MiniSerieDto getMiniSerie(Long id){
        MiniSerie miniSerie = miniSerieRepository.findById(id)
                .orElseThrow(()->new BadRequest("No miniserie has this id"));

        return GlobalMapper.entityToDto(miniSerie);
    }

}
