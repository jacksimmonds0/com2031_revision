package org.com2031.greedy;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalScheduling {
  
  public IntervalScheduling() {
    super();
  }
  
  public List<Job> schedule(List<Job> jobs) {
    // sort all the jobs in order of end time
    jobs = this.sortByEndTime(jobs);
    List<Job> schedule = new ArrayList<Job>();
    
    // add initial job with lowest end time to the schedule
    schedule.add(jobs.get(0));
    
    for(int j = 1; j < jobs.size(); j++) {
      // if the job is compatible with the last in the schedule - add it to the schedule
      if(jobs.get(j).getStartTime() >= schedule.get(schedule.size()-1).getEndTime()) {
        schedule.add(jobs.get(j));
      }
    }
    
    return schedule;
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
