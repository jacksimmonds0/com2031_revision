package org.com2031.greedy;


public class Job {

  private int startTime = 0;
  private int endTime = 0;
  
  public Job(int startTime, int endTime) {
    super();
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
  public int getStartTime() {
    return this.startTime;
  }
  
  public int getEndTime() {
    return this.endTime;
  }
  
  @Override
  public String toString() {
    return "(" + this.startTime + " -> " + this.endTime + ")";
  }
}
