package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import Utilities.Conversions;
import controllers.StationCtrl;
import play.db.jpa.Model;

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
    public String date;

    /**
     * Constructor for a new Station with 4 parameters:
     * @param name       name of the station
     * @param code       weather code
     * @param windSpeed  wind speed for the station
     * @param pressure   pressure for the station
     */
    public Station(String name, int code, double windSpeed, int pressure) {
        this.name = name;
        this.code = code;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }
    /**
     * Constructor that creates a new Station with 3 parameters
     * @param name      the name of the station
     * @param latitude  the latitude of the station
     * @param longitude the longitude of the station
     */
    public Station(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Returns the latitude and longitude of the station.
     * @return the latitude for the first method
     * @return the longitude for the second method
     */
    public double getLatitude() {
        return this.latitude;
    }
    public double getLongitude() {
        return this.longitude;
    }

    /**
     * Returns the last reading entered for weather condition according to the code.
     * @return the weather condition
     */
    public String lastWeatherCondition() {
        Reading lastReading = readings.get(readings.size() - 1);
        int weatherCode = lastReading.code;
        String weatherCondition = Conversions.convertToWCondition(weatherCode);
        return weatherCondition;
    }
    /**
     * Returns the last temperature entered in Celsius for the station.
     * @return last temperature in Celsius
     */
    public double lastTempC() {
        Reading lastReading = readings.get(readings.size() - 1);
        return lastReading.temperature;
    }

    /**
     * Returns the last temperature entered in Fahrenheit for the station.
     * @return last temperature in Fahrenheit
     */
    public double lastTempF() {
        double lastTempCelsius = lastTempC();
        return Math.round(Conversions.convertToFahrenheit(lastTempCelsius)*10 / 10);
    }

    /**
     * Returns the Beaufort converted value for the last entered wind speed
     * @return Beaufort value
     */
    public int lastWindSpeedBeaufort() {
        Reading lastReading = readings.get(readings.size() - 1);
        double windSpeedKm = lastReading.windSpeed;
        int windSpeedBeaufort = Conversions.convertToBeaufort(windSpeedKm);
        return windSpeedBeaufort;
    }
    /**
     * Returns the direction of the last entered wind direction
     * @return wind compass direction
     */
    public String lastWindDirection() {
        Reading lastReading = readings.get(readings.size() - 1);
        double degreeRange = lastReading.windDirection;
        String compassDirection = Conversions.convertToWDirection(degreeRange);
        return compassDirection;
    }
    /**
     * Returns the last entered pressure value
     * @return last pressure
     */
    public int lastPressure() {
        Reading lastReading = readings.get(readings.size() - 1);
        return lastReading.pressure;
    }

    /**
     * Returns the last entered "Feels like" wind chill temperature in Celsius value
     * @return wind chill temperature
     */
    public double lastWindChill() {
        Reading lastReading = readings.get(readings.size() - 1);
        double lastTempCelsius = lastReading.temperature;
        double lastWindSpeed = lastReading.windSpeed;
        double windChill = Conversions.convertToWindChill(lastTempCelsius, lastWindSpeed);
        return Math.round(windChill * 10) / 10.0;
    }


}
