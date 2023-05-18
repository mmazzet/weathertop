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

  /**
   * Constructor that creates a new Reading with 5 parameters as below:
   *
   * @param name        the name of the reading
   * @param code        the code of the reading
   * @param temperature the temperature value of the reading
   * @param windSpeed   the wind speed value of the reading
   * @param pressure    the pressure value of the reading
   */
  public Reading(String name, int code, double temperature, double windSpeed, int pressure) {
    this.name = name;
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
  }
  /**
   * Constructor that creates a new Reading with 5 parameters as below:
   * @param code          the code of the reading
   * @param temperature   the temperature value of the reading
   * @param windSpeed     the wind speed value of the reading
   * @param windDirection the wind direction value of the reading
   * @param pressure      the pressure value of the reading
   */
  public Reading(int code, double temperature, double windSpeed, double windDirection, int pressure) {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.pressure = pressure;
    this.windDirection = windDirection;
  }

  /**
   * Constructor that creates a new Reading with 2 parameters as below:
   * @param latitude  the latitude coordinate of the reading
   * @param longitude the longitude coordinate of the reading
   */
  public Reading(double latitude, double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }

}