package org.example.ejercicio1;

public class CityStats {
    public String cityName;
    public int minTemp;
    public int maxTemp;

    public CityStats(String cityName, int minTemp, int maxTemp) {
        this.cityName = cityName;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }
}


