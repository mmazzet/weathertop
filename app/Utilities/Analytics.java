package Utilities;
import models.Reading;
import java.util.List;
public class Analytics {
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
