package entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

  private String account_id;
  private String username;
  private String password;

  @JsonCreator
  public User(@JsonProperty("username") String username, @JsonProperty("password") String password) {
    this.account_id = UUID.randomUUID().toString();
    this.username = username;
    this.password = password;
  }

  public String getAccount_id() {
    return account_id;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return User.class.getSimpleName() + "[id: " + this.account_id + ", username: " + this.username + ", password: "
        + this.password + "]";
  }
}