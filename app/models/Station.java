package models;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import Utilities.Conversions;
import controllers.StationCtrl;
import play.db.jpa.Model;

import static controllers.StationCtrl.addReading;


@Entity
public class Station extends Model {
    public String name;
    public int code;

    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    public double windSpeed;
    public double windDirection;
    public int pressure;
    public double temperature;
    public double latitude;
    public double longitude;

    public Station(String name, int code, double windSpeed, int pressure) {
        this.name = name;
        this.code = code;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    public Station(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }

    public String lastWeatherCondition() {
        Reading lastReading = readings.get(readings.size() - 1);
        int weatherCode = lastReading.code;
        String weatherCondition = Conversions.convertToWCondition(weatherCode);
        return weatherCondition;
    }

    public double lastTempC() {
        Reading lastReading = readings.get(readings.size() - 1);
        return lastReading.temperature;
    }


    public double lastTempF() {
        double lastTempCelsius = lastTempC();
        return Math.round(Conversions.convertToFahrenheit(lastTempCelsius)*10 / 10);
    }

    public int lastWindSpeedBeaufort() {
        Reading lastReading = readings.get(readings.size() - 1);
        double windSpeedKm = lastReading.windSpeed;
        int windSpeedBeaufort = Conversions.convertToBeaufort(windSpeedKm);
        return windSpeedBeaufort;
    }

    public String lastWindDirection() {
        Reading lastReading = readings.get(readings.size() - 1);
        double degreeRange = lastReading.windDirection;
        String compassDirection = Conversions.convertToWDirection(degreeRange);
        return compassDirection;
    }

    public int lastPressure() {
        Reading lastReading = readings.get(readings.size() - 1);
        return lastReading.pressure;
    }

    public double lastWindChill() {
        Reading lastReading = readings.get(readings.size() - 1);
        double lastTempCelsius = lastReading.temperature;
        double lastWindSpeed = lastReading.windSpeed;
        double windChill = Conversions.convertToWindChill(lastTempCelsius, lastWindSpeed);
        return Math.round(windChill * 10) / 10.0;
    }

//    public String addDate() {
//        Timestamp ts = new Timestamp(System.currentTimeMillis());
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        return formatter.format(ts);
//    }

}
