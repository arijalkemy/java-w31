package com.example.AgePerson.Service;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class AgeServiceImpl implements IAgeService {
    @Override
    public Integer calculateAge(Integer month, Integer day, Integer year) {

        Calendar dateNow = Calendar.getInstance();
        Integer age = dateNow.get(Calendar.YEAR) - year;
        Integer monthh = dateNow.get(Calendar.MONTH) - (month - 1);
        Integer days = dateNow.get(Calendar.DATE) - day;

        if (monthh < month || monthh == month && days < day) {
            age--;
        }
        return age;
    }

}
