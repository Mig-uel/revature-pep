package entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
  private String message_id;
  private String message_text;
  private String posted_by;

  @JsonCreator
  public Message(
      @JsonProperty("message_text") String message_text,
      @JsonProperty("posted_by") String posted_by) {
    this.message_id = UUID.randomUUID().toString();
    this.message_text = message_text;
    this.posted_by = posted_by;
  }

  public String getMessage_id() {
    return message_id;
  }

  public String getMessage_text() {
    return message_text;
  }

  public String getPosted_by() {
    return posted_by;
  }

  public void setMessage_text(String message_text) {
    this.message_text = message_text;
  }

  public void setPosted_by(String posted_by) {
    this.posted_by = posted_by;
  }
}
