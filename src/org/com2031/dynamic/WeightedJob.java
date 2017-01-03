package org.com2031.dynamic;

import org.com2031.greedy.Job;

public class WeightedJob extends Job {

  private int weight = 0;
  
  public WeightedJob(int startTime, int endTime, int weight) {
    super(startTime, endTime);
    this.weight = weight;
  }
  
  public int getWeight() {
    return this.weight;
  }
  
  @Override
  public String toString() {
    return "(" + super.startTime + " -> " + super.endTime + ", w = " + this.weight +")";
  }
}
