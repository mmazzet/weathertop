package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import Utilities.Analytics;

/**
 * Manages station activities for adding and deleting readings and min max readings
 */
public class StationCtrl extends Controller {
  /**
   * Shows the station details and readings.
   * @param id id of the station
   */
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info ("Station id = " + id);
    Reading minTempReading = Analytics.getMinTemperature(station.readings);
    Reading maxTempReading = Analytics.getMaxTemperature(station.readings);
    Reading minPressReading = Analytics.getMinPressure(station.readings);
    Reading maxPressReading = Analytics.getMaxPressure(station.readings);
    Reading minWindSReading = Analytics.getMinWindSpeed(station.readings);
    Reading maxWindSReading = Analytics.getMaxWindSpeed(station.readings);
    render("station.html", station, minTempReading, maxTempReading, minPressReading, maxPressReading,
        minWindSReading, maxWindSReading);
  }
  /**
   * Adds a new reading to the station.
   *
   * @param id           id of the station
   * @param code         code of the reading
   * @param temperature  temperature of the reading
   * @param windSpeed    wind speed of the reading
   * @param windDirection wind direction of the reading
   * @param pressure     pressure of the reading
   */
  public static void addReading(Long id, int code, double temperature, double windSpeed,
                                double windDirection, int pressure) {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    redirect ("/stations/" + id);
  }
  /**
   * Deletes a reading from the station.
   * @param id        id of the station
   * @param readingid id of the reading to delete
   */
  public static void deleteReading (Long id, Long readingid) {
    Station station = Station.findById(id);
    Reading reading = Reading.findById(readingid);
    Logger.info ("Removing " + reading.code);
    Reading minTempReading = Analytics.getMinTemperature(station.readings);
    Reading maxTempReading = Analytics.getMaxTemperature(station.readings);
    Reading minPressReading = Analytics.getMinPressure(station.readings);
    Reading maxPressReading = Analytics.getMaxPressure(station.readings);
    Reading minWindSReading = Analytics.getMinWindSpeed(station.readings);
    Reading maxWindSReading = Analytics.getMaxWindSpeed(station.readings);
    station.readings.remove(reading);
    station.save();
    reading.delete();
    render("station.html", station, minTempReading, maxTempReading, minPressReading, maxPressReading,
        minWindSReading, maxWindSReading);
  }

}

