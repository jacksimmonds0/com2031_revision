package org.com2031.greedy;

import java.util.List;
import java.util.ArrayList;

public class Room implements Comparable<Room> {

  private int number = 0;
  private List<Job> jobs = null;
  
  public Room(int number) {
    super();
    this.number = number;
    this.jobs = new ArrayList<Job>();
  }
  
  public int getNumber() {
    return this.number;
  }
  
  public List<Job> getJobs() {
    return this.jobs;
  }
  
  public void addJob(Job j) {
    jobs.add(j);
  }
  
  /**
   * Comparable method used to sort the priority queue so that the lowest end time
   * comparing the rooms current jobs list last element is always at the top
   */
  @Override
  public int compareTo(Room r) {
    return Integer.compare(this.jobs.get(jobs.size()-1).getEndTime(), r.getJobs().get(r.getJobs().size()-1).getEndTime());
  }
  
  @Override
  public String toString() {
    return "Room " + this.number + ": " + this.jobs;
  }
}
