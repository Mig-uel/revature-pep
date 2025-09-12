package dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageUpdateDto {
  private String message_text;

  @JsonCreator
  public MessageUpdateDto(@JsonProperty("message_text") String message_text) {
    this.message_text = message_text;
  }

  public String getMessage_text() {
    return message_text;
  }

  public void setMessage_text(String message_text) {
    this.message_text = message_text;
  }
}