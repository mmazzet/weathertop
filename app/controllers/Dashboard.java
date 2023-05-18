package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

/**
 * Controller class used to manage actions in the Dashboard
 */
public class Dashboard extends Controller {
  /**
   * Renders the dashboard page
   */
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = member.stations;
    render ("dashboard.html", stations);
  }

  /**
   * Adds a new station containing name, latitude and longitude entered by user.
   * If the name is a duplicate, it displays an error message and redirects to the dashboard
   * @param name      name of the station
   * @param latitude  latitude of the station
   * @param longitude longitude of the station
   */
  public static void addStation(String name, double latitude, double longitude) {
    Logger.info("Adding a new station called " + name);
    Member member = Accounts.getLoggedInMember();

    // Check if the station name already exists
    if (isDuplicateStationName(member, name)) {
      flash.error("Station name already exists. Enter a new Station.");
      redirect("/dashboard");
    }
    Station station = new Station(name, latitude, longitude);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }

  /**
   * Checks if the entered station name already exists for the logged-in user
   * @param member logged-in member
   * @param name   name of the station to check
   * @return true if the station name already exists, false otherwise
   */
  private static boolean isDuplicateStationName(Member member, String name) {
    for (Station station : member.stations) {
      if (station.name.equalsIgnoreCase(name)) {
        return true;
      }
    }
    return false;
  }

  /**
   * Deletes a station with a specific id
   * @param id id of the station to delete
   */
  public static void deleteStation (Long id) {
    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }
}

