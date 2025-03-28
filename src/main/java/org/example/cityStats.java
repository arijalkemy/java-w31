package org.example;

public class cityStats {
    public String cityName;
    public int minTemp;
    public int maxTemp;

    public cityStats(String cityName, int minTemp, int maxTemp) {
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


