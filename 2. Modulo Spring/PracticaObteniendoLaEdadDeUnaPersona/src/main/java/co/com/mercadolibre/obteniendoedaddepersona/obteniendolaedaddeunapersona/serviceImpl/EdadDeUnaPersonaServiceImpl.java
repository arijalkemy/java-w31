package co.com.mercadolibre.obteniendoedaddepersona.obteniendolaedaddeunapersona.serviceImpl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.obteniendoedaddepersona.obteniendolaedaddeunapersona.exception.NumberException;
import co.com.mercadolibre.obteniendoedaddepersona.service.EdadDeUnaPersonaService;

@Service
public class EdadDeUnaPersonaServiceImpl implements EdadDeUnaPersonaService{

    @Override
    public int getPeopleAge(int day, int month, int year) {
        int userAge = 0;
        try {
            LocalDate userBirthDate = LocalDate.of(year, month, month);
            LocalDate currentDate = LocalDate.now();
            Period period = userBirthDate.until(currentDate);
            userAge = period.getYears();
            
        } catch (NumberException n) {
            throw new NumberException("We got some errors while processing your request: " 
            + n.getMessage());
        }

        return userAge;
        
    }

}
