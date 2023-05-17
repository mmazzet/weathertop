package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import Utilities.Conversions;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Reading extends Model {
    public String name;
    public String date;
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public int pressure;
    public double longitude;
    public double latitude;


  public Reading(String name, int code, double temperature, double windSpeed, int pressure) {
        this.name = name;
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }
    public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }
  public Reading (double latitude, double longitude){
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Reading (String date) {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    this.date = FORMATTER.format(LocalDateTime.now());
  }
}