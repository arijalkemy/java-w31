package com.mercadolibre.covid;

import com.mercadolibre.covid.model.Persona;
import com.mercadolibre.covid.model.PersonaEnRiesgo;
import com.mercadolibre.covid.model.Sintoma;

public class BaseDeDatos {
    public static final Persona[] personas = {
      new Persona("1", "Jose", "Sanchez", 28),
      new Persona("2", "Carla", "Perez", 78),
      new Persona("3", "Federico", "Mancla", 90),
      new Persona("4", "Lucas", "Destro", 50),
      new Persona("5", "Maria", "Gomez", 42),
    };

    public static final Sintoma[] sintomas = {
            new Sintoma("1", "Tos", 1),
            new Sintoma("2", "Fiebre", 2),
            new Sintoma("3", "Mocos", 1),
            new Sintoma("4", "Dolor de cabeza", 2),
            new Sintoma("5", "Perdida de olfato", 3),
            new Sintoma("6", "Dolor muscular", 3),
            new Sintoma("7", "Cansancio", 1),
    };

    public static final PersonaEnRiesgo[] personas_en_riesgo = {
            new PersonaEnRiesgo("6", "Gabriel", "Gonzalez", 70, new Sintoma[]{sintomas[1], sintomas[3], sintomas[4]}),
            new PersonaEnRiesgo("7", "Hugo", "Lopez", 65, new Sintoma[]{sintomas[5], sintomas[3], sintomas[6]}),
            new PersonaEnRiesgo("8", "Juana", "Fernandez", 72, new Sintoma[]{sintomas[1], sintomas[6], sintomas[4]}),
    };
}
