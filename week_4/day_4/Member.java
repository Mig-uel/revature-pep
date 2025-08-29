package week_4.day_4;

import java.sql.Date;

public class Member {
  private String email;
  private String password;
  private String full_name;
  private int experience_months;
  private Date registration_date;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setFull_name(String full_name) {
    this.full_name = full_name;
  }

  public void setExperience_months(int experience_months) {
    this.experience_months = experience_months;
  }

  public void setRegistration_date(Date registration_date) {
    this.registration_date = registration_date;
  }

  public String getPassword() {
    return password;
  }
  
  public String getFull_name() {
    return full_name;
  }

  public int getExperience_months() {
    return experience_months;
  }

  public Date getRegistration_date() {
    return registration_date;
  }
}