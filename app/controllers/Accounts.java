package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

/**
 * Controller class to manage user signup, login and authentication of user
 */
public class Accounts extends Controller {
  public static void signup() {
    render("signup.html");
  }

  public static void login() {
    render("login.html");
  }

  /**
   * Signs up a new user with the information below
   *
   * @param firstname first name of the user
   * @param lastname  last name of the user
   * @param email     email of the user
   * @param password  password of the user
   */
  public static void register(String firstname, String lastname, String email, String password) {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password);
    member.save();
    redirect("/login");
  }

  /**
   * Verifies a member with the provided email and password.
   *
   * @param email    email of the member
   * @param password password of the member
   */
  public static void authenticate(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);
    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Authentication failed");
      flash.error("Wrong email or password");
      redirect("/login");
    }
  }

  /**
   * Logs out user who is logged in
   */
  public static void logout() {
    session.clear();
    redirect("/");
  }

  /**
   * Locates a logged-in user, used when stations are added or deleted
   *
   * @return the logged-in user. If no user found, redirects to the login page
   */
  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }


}

