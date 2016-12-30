package org.com2031.greedy;


public class Task {
  
  private int duration = 0;
  private int deadline = 0;
  
  public Task(int duration, int deadline) {
    super();
    this.duration = duration;
    this.deadline = deadline;
  }
  
  public int getDuration() {
    return this.duration;
  }
  
  public int getDeadline() {
    return this.deadline;
  }
  
  @Override
  public String toString() {
    return "(t = " + this.duration + ", d = " + this.deadline + ")";
  }

}
