package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends Model {
  public String firstname;
  public String lastname;
  public String email;
  public String password;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Station> stations = new ArrayList<Station>();

  /**
   * Constructor to create a new instance of user
   *
   * @param firstname first name of the user
   * @param lastname  last name of the user
   * @param email     email of the user
   * @param password  password of the user
   */
  public Member(String firstname, String lastname, String email, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
  }

  /**
   * Uses the email to find a user
   *
   * @param email used for the search
   * @return the user email
   */
  public static Member findByEmail(String email) {
    return find("email", email).first();
  }

  /**
   * Checks if the password is the same the user's password.
   *
   * @param password password to check
   * @return true if password is the same, false otherwise
   */
  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }
}
