package co.com.mercadolibre.practicadeportistas.practicadeportistas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.domain.Sport;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.SportDto;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.enums.SPORT_LEVEL;

@Service
public class SportServiceImpl implements SportService {


    @Override
    public List<SportDto> getSports() {
        List<Sport> sportsList = List.of(
            new Sport("Soccer", SPORT_LEVEL.EASY),
            new Sport("Basketball", SPORT_LEVEL.EXTREMELY_HARD),
            new Sport("Boxing", SPORT_LEVEL.EXTREMELY_HARD),
            new Sport("Running", SPORT_LEVEL.EXTREMELY_HARD));
            return sportsList.stream()
            .map(s -> new SportDto(s.getName(), s.getnLevel())).toList();
    }

    @Override
    public SportDto findSportByName(String sportName) {
        Optional<Sport> sport = Optional.ofNullable(new Sport("Soccer", SPORT_LEVEL.EASY));
        if (sport.get().getName().equalsIgnoreCase(sportName)) {
            return sport.map(s -> {
                return new SportDto(null, s.getnLevel());
            }).orElseGet(null);
        }
        return sport.map(s -> new SportDto(null, null)).get();
        
    }

}
