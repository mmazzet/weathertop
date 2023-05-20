package Utilities;

import models.Reading;
import java.util.List;

/**
 * Analytics class under Utilities package used for maximum and minimum readings.
 */
public class Analytics {

  /**
   * Returns Reading with the lowest temperature from a list of readings.
   *
   * @param readings the list of readings
   * @return the minimum temperature in a list of readings. It's null if empty
   */
  public static Reading getMinTemperature(List<Reading> readings) {
    Reading minTempReading = null;
    if (readings.size() > 0) {
      minTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temperature < minTempReading.temperature) {
          minTempReading = reading;
        }
      }
    }
    return minTempReading;
  }

  /**
   * Returns Reading with the highest temperature from a list of readings.
   *
   * @param readings the list of readings
   * @return the maximum temperature in a list of readings. It's null if empty
   */
  public static Reading getMaxTemperature(List<Reading> readings) {
    Reading maxTempReading = null;
    if (readings.size() > 0) {
      maxTempReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.temperature > maxTempReading.temperature) {
          maxTempReading = reading;
        }
      }
    }
    return maxTempReading;
  }

  /**
   * Returns Reading with the lowest pressure from a list of readings.
   *
   * @param readings the list of readings
   * @return the minimum  pressure in a list of readings. It's null if empty
   */
  public static Reading getMinPressure(List<Reading> readings) {
    Reading minPressReading = null;
    if (readings.size() > 0) {
      minPressReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure < minPressReading.pressure) {
          minPressReading = reading;
        }
      }
    }
    return minPressReading;
  }

  /**
   * Returns Reading with the highest pressure from a list of readings.
   *
   * @param readings the list of readings
   * @return the maximum pressure in a list of readings. It's null if empty
   */
  public static Reading getMaxPressure(List<Reading> readings) {
    Reading maxPressReading = null;
    if (readings.size() > 0) {
      maxPressReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.pressure > maxPressReading.pressure) {
          maxPressReading = reading;
        }
      }
    }
    return maxPressReading;
  }

  /**
   * Returns Reading with the lowest wind speed from a list of readings.
   *
   * @param readings the list of readings
   * @return the minimum wind speed in a list of readings. It's null if empty
   */
  public static Reading getMinWindSpeed(List<Reading> readings) {
    Reading minWindSReading = null;
    if (readings.size() > 0) {
      minWindSReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed < minWindSReading.windSpeed) {
          minWindSReading = reading;
        }
      }
    }
    return minWindSReading;
  }

  /**
   * Returns Reading with the highest wind speed from a list of readings.
   *
   * @param readings the list of readings
   * @return the maximum wind speed in a list of readings. It's null if empty
   */
  public static Reading getMaxWindSpeed(List<Reading> readings) {
    Reading maxWindSReading = null;
    if (readings.size() > 0) {
      maxWindSReading = readings.get(0);
      for (Reading reading : readings) {
        if (reading.windSpeed > maxWindSReading.windSpeed) {
          maxWindSReading = reading;
        }
      }
    }
    return maxWindSReading;
  }
}
