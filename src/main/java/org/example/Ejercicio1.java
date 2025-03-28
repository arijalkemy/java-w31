package org.example;

import java.util.*;


public class Ejercicio1 {
    private static String[] cities;
    private static int[] minTemps;
    private static int[] maxTemps;

    public void findCities() {
        Ejercicio1.cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        Ejercicio1.minTemps = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        Ejercicio1.maxTemps = new int[]{33, 32, 27, 37, 42, 43, 39, 26, 31, 35};

        int min_temp_index = 0;
        int max_temp_index = 0;
        int min_temp = 0;
        int max_temp = 0;

        for (int i = 0; i < Ejercicio1.cities.length; i++) {
            if (Ejercicio1.minTemps[i] < min_temp) {
                min_temp = Ejercicio1.minTemps[i];
                min_temp_index = i;
            }

            if (Ejercicio1.maxTemps[i] > max_temp) {
                max_temp = Ejercicio1.maxTemps[i];
                max_temp_index = i;
            }
        }

        System.out.println("The city with the minimum temperature is: " + cities[min_temp_index] + " with a minimum temperature: " + minTemps[min_temp_index]);
        System.out.println("The city with the maximum temperature is " + cities[max_temp_index] + " with a maximum temperature: " + maxTemps[max_temp_index]);
    }

    public void find_cities_streams() {
        Ejercicio1.cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        Ejercicio1.minTemps = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        Ejercicio1.maxTemps = new int[]{33, 32, 27, 37, 42, 43, 39, 26, 31, 35};

        CityStats[] citiesStats = new CityStats[Ejercicio1.cities.length];

        // Creating objects for each city
        for (int i = 0; i < Ejercicio1.cities.length; i++) {
            CityStats city = new CityStats(Ejercicio1.cities[i], Ejercicio1.minTemps[i], Ejercicio1.maxTemps[i]);
            citiesStats[i] = city;
        }

        Optional<CityStats> min_temp_city = Arrays.stream(citiesStats).min(Comparator.comparing(CityStats::getMinTemp));
        min_temp_city.ifPresent(CityStats -> System.out.println("The city with the minimum temp is " + CityStats.cityName + " with a min temp of " + CityStats.minTemp));

        Optional<CityStats> max_temp_city = Arrays.stream(citiesStats).max(Comparator.comparing(CityStats::getMaxTemp));
        max_temp_city.ifPresent(CityStats -> System.out.println("The city with the max temp is " + CityStats.cityName + " with a max temp of " + CityStats.maxTemp));

    }
}
