package Utilities;

import java.util.ArrayList;
import java.util.List;

import models.Reading;
import models.Station;


import play.db.jpa.Model;

/**
 * Conversion class used for a range of conversion methods for weather data.
 */

public class Conversions {

  /**
   * Converts temperature in Celsius to Fahrenheit
   * @param temperature temperature in Celsius
   * @return temperature in Fahrenheit
   */
  public static double convertToFahrenheit(double temperature){
    double fahrenheit = temperature * 9 / 5 + 32;
    return fahrenheit;
  }

  /**
   * Converts WindSpeed to Beaufort scale
   * @param windSpeed the wind speed in km/h
   * @return the corresponding Beaufort scale value
   */
  public static int convertToBeaufort(double windSpeed) {
    if (windSpeed <= 1.0) {
      return 0;
    } else if (windSpeed > 1.0 && windSpeed <= 5.99) {
      return 1;
    } else if (windSpeed >= 6.0 && windSpeed <= 11.99) {
      return 2;
    } else if (windSpeed >= 12.0 && windSpeed <= 19.99) {
      return 3;
    } else if (windSpeed >= 20.0 && windSpeed <= 28.99) {
      return 4;
    } else if (windSpeed >= 29.0 && windSpeed <= 38.99) {
      return 5;
    } else if (windSpeed >= 39.0 && windSpeed <= 49.99) {
      return 6;
    } else if (windSpeed >= 50.0 && windSpeed <= 61.99) {
      return 7;
    } else if (windSpeed >= 62.0 && windSpeed <= 74.99) {
      return 8;
    } else if (windSpeed >= 75.0 && windSpeed <= 88.99) {
      return 9;
    } else if (windSpeed >= 89.0 && windSpeed <= 102.99) {
      return 10;
    } else if (windSpeed >= 103.0 && windSpeed <= 117.99) {
      return 11;
    }
    else {
      // speed > than 117.99
      return -1;
    }
  }
  /**
   * Converts a Weather code to weather condition
   * @param code weather code as per brief
   * @return weatherString the matching weather condition as per brief
   */
  public static String convertToWCondition(int code) {
    String weatherString = "";
      switch (code) {
        case 100:
          weatherString = "Clear";
          break;
        case 200:
          weatherString = "Partial Clouds";
          break;
        case 300:
          weatherString = "Cloudy";
          break;
        case 400:
          weatherString = "Light Showers";
          break;
        case 500:
          weatherString = "Heavy Showers";
          break;
        case 600:
          weatherString = "Rain";
          break;
        case 700:
          weatherString = "Snow";
          break;
        case 800:
          weatherString = "Thunder";
          break;
        default: weatherString = "Not available";
      }
    return weatherString;
  }

  /**
   * Converts Wind direction degree ranges to compass direction
   * @param windDirection the wind direction in degrees
   * @return the corresponding compass direction
   */
  public static String convertToWDirection(double windDirection) {
    if (windDirection >= 348.75 && windDirection <= 360) {
      return "North";
    } else if (windDirection >= 0 && windDirection <= 11.25) {
      return "North";
    } else if (windDirection > 11.25 && windDirection <= 33.75) {
      return "NNE";
    } else if (windDirection > 33.75 && windDirection <= 56.25) {
      return "NE";
    } else if (windDirection > 56.25 && windDirection <= 78.75) {
      return "ENE";
    } else if (windDirection > 78.75 && windDirection <= 101.25) {
      return "East";
    } else if (windDirection > 101.25 && windDirection <= 123.75) {
      return "ESE";
    } else if (windDirection > 123.75 && windDirection <= 146.25) {
      return "SE";
    } else if (windDirection > 146.25 && windDirection <= 168.75) {
      return "SSE";
    } else if (windDirection > 168.75 && windDirection <= 191.25) {
      return "South";
    } else if (windDirection > 191.25 && windDirection <= 213.75) {
      return "SSW";
    } else if (windDirection > 213.75 && windDirection <= 236.25) {
      return "SW";
    } else if (windDirection > 236.25 && windDirection <= 258.75) {
      return "WSW";
    } else if (windDirection > 258.75 && windDirection <= 281.25) {
      return "West";
    } else if (windDirection > 281.25 && windDirection <= 303.75) {
      return "WNW";
    } else if (windDirection > 303.75 && windDirection <= 326.25) {
      return "NW";
    } else if (windDirection > 326.25 && windDirection <= 348.75) {
      return "NNW";
    }
    else {
      // value not in range 0-360 degrees
      return "Enter value from 0 to 360";
    }
  }
  /**
   * Returns  the wind chill factor according to temperature and wind speed.
   * @param temperature the temperature in Celsius
   * @param windSpeed the wind speed in km/h
   * @return windChill the wind chill temperature in Celsius
   */
  public static double convertToWindChill(double temperature, double windSpeed){
    double windChill = 13.12 + 0.6215*temperature - 11.37 *(Math.pow(windSpeed,0.16)) +
                        0.3965*temperature*(Math.pow(windSpeed,0.16));
    return windChill;
  }
}
