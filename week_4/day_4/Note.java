package week_4.day_4;

public class Note {
  // fields
  private long id;
  private String content;
  private String priority;

  // ... constructors, getters, and setters omitted
  Note(long id, String content, String priority) {
    this.id = id;
    this.content = content;
    this.priority = priority;
  }

  public String getContent() {
    return content;
  }

  public String getPriority() {
    return priority;
  }

  public long getId() {
    return id;
  }
}