package model;

public class Employee extends Person {
  private String id;
  private int salary;
  private boolean available = true;

  public Employee(String name, String id, int salary) {
    super(name);
    this.id = id;
    this.salary = salary;
  }

  public boolean isAvailable() {
    return this.available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public String getId() {
    return id;
  }
}
