package org.example;

import java.util.*;


public class ejercicio1 {
    private static String[] cities;
    private static int[] min_temps;
    private static int[] max_temps;

    public void findCities() {
        ejercicio1.cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        ejercicio1.min_temps = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        ejercicio1.max_temps = new int[]{33, 32, 27, 37, 42, 43, 39, 26, 31, 35};

        int min_temp_index = 0;
        int max_temp_index = 0;
        int min_temp = 0;
        int max_temp = 0;

        for (int i = 0; i < ejercicio1.cities.length; i++) {
            if (ejercicio1.min_temps[i] < min_temp) {
                min_temp = ejercicio1.min_temps[i];
                min_temp_index = i;
            }

            if (ejercicio1.max_temps[i] > max_temp) {
                max_temp = ejercicio1.max_temps[i];
                max_temp_index = i;
            }
        }

        System.out.println("The city with the minimum temperature is: " + cities[min_temp_index] + " with a minimum temperature: " + min_temps[min_temp_index]);
        System.out.println("The city with the maximum temperature is " + cities[max_temp_index] + " with a maximum temperature: " + max_temps[max_temp_index]);
    }

    public void find_cities_streams() {
        ejercicio1.cities = new String[]{"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        ejercicio1.min_temps = new int[]{-2, -3, -8, 4, 6, 5, 0, -7, -1, -10};
        ejercicio1.max_temps = new int[]{33, 32, 27, 37, 42, 43, 39, 26, 31, 35};

        cityStats[] citiesStats = new cityStats[ejercicio1.cities.length];

        // Creating objects for each city
        for (int i = 0; i < ejercicio1.cities.length; i++) {
            cityStats city = new cityStats(ejercicio1.cities[i], ejercicio1.min_temps[i], ejercicio1.max_temps[i]);
            citiesStats[i] = city;
        }

        Optional<cityStats> min_temp_city = Arrays.stream(citiesStats).min(Comparator.comparing(cityStats::getMinTemp));
        min_temp_city.ifPresent(cityStats -> System.out.println("The city with the minimum temp is " + cityStats.cityName + " with a min temp of " + cityStats.minTemp));

        Optional<cityStats> max_temp_city = Arrays.stream(citiesStats).max(Comparator.comparing(cityStats::getMaxTemp));
        max_temp_city.ifPresent(cityStats -> System.out.println("The city with the max temp is " + cityStats.cityName + " with a max temp of " + cityStats.maxTemp));

    }
}
