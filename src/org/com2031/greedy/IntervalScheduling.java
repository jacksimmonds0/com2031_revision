package org.com2031.greedy;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalScheduling {

  private List<Job> jobs = new ArrayList<Job>();
  
  public IntervalScheduling() {
    super();
  }
  
  
  
  public List<Job> sortByEndTime(List<Job> jobs) {
    Collections.sort(jobs, new Comparator<Job>() {
      @Override
      public int compare(Job j1, Job j2) {
        return j1.getEndTime() - j2.getEndTime();
      }
    });
    
    return jobs;
  }
  
}
