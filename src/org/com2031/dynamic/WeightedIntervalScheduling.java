package org.com2031.dynamic;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WeightedIntervalScheduling {
  
  private List<WeightedJob> jobs = null;
  private int[] memoTable = null;     // memoization table
  private int[] compatible = null;    // values for p(1), p(2) ... p(n)
  
  public WeightedIntervalScheduling(List<WeightedJob> jobs) {
    super();
    // pre-processing to sort the input list by finish time
    this.jobs = this.sortByEndTime(jobs);
    
    // initialise the memo table based on the jobs input
    this.memoTable = new int[jobs.size()+1];
    
    // set values for all jobs of p(i)
    this.compatible = new int[jobs.size()+1];
    this.setCompatible();
    
  }
  
  public int[] schedule() {
    memoTable[0] = 0;
    
    for(int j = 1; j <= jobs.size(); j++) {
      memoTable[j] = Math.max(jobs.get(j-1).getWeight() + memoTable[compatible[j]], memoTable[j-1]);
    }
    
    return memoTable;
  }
  
  /**
   * Worst case this can be O(n^2) but generally should be ~O(n)
   */
  private void setCompatible() {
    compatible[0] = 0;
    // loop through all jobs
    for(int i = 1; i <= jobs.size(); i++) {
      WeightedJob job = jobs.get(i-1);
      
      // loop backwards from current job and compare
      innerloop:
      for(int j = i-1; j >= 0; j--) {
        
        // if compatible assign index to the array
        if(job.getStartTime() >= jobs.get(j).getEndTime()) {
          compatible[i] = j+1;
          // break from this loop since it has been assigned correctly
          break innerloop;
        }
        // otherwise nothing compatible so assign 0
        else if(j == 0) {
          compatible[i] = 0;
        }
      }
    }
  }
  
  /**
   * Post-processing to find the optimal schedule with maximum weight based on the memo table
   */
  public List<WeightedJob> findSchedule() {
    List<WeightedJob> schedule = new ArrayList<WeightedJob>();
    int lastIndexAdded = 0;
    
    for(int i = jobs.size(); i > 0; i--) {
      // prevent i+1 causing index out of bounds exception
      if(i != memoTable.length-1 && !schedule.isEmpty()) {
        // skip to next iteration if not compatible with jobs already added
        if(compatible[lastIndexAdded] < i) {
          continue;
        }
      }
      
      if(jobs.get(i-1).getWeight() + memoTable[compatible[i]] > memoTable[i-1]) {
        schedule.add(0, jobs.get(i-1));
        lastIndexAdded = i;
      }     
    }
    
    return schedule;
  }
  
  public List<WeightedJob> sortByEndTime(List<WeightedJob> jobs) {
    Collections.sort(jobs, new Comparator<WeightedJob>() {
      @Override
      public int compare(WeightedJob j1, WeightedJob j2) {
        return j1.getEndTime() - j2.getEndTime();
      }
    });
    
    return jobs;
  }
  
  public int[] getCompatible() {
    return this.compatible;
  }

}
