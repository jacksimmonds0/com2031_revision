package org.com2031.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class MinimizingLateness {

  private int lateness = 0;
  
  public MinimizingLateness() {
    super();
  }
  
  public List<Job> planIntervals(List<Task> tasks) {
    // sort the tasks by deadline in ascending order
    tasks = this.sortByDeadline(tasks);
    
    // using job class as interval template in this case
    List<Job> intervals = new ArrayList<Job>();
    int currentTime  = 0;
    
    for(int j = 0; j < tasks.size(); j++) {
      // add the task to the intervals sequentially with the start time as the current time -> time + duration
      intervals.add(new Job(currentTime, currentTime + tasks.get(j).getDuration()));
      
      // increment the current time by the duration of the current task/task just added
      currentTime += tasks.get(j).getDuration();
      
      // if statement to help show the lateness of the intervals
      if(currentTime > tasks.get(j).getDeadline()) {
        // add to the lateness variable to show the overall lateness of the intervals
        lateness += currentTime - tasks.get(j).getDeadline();
      }
    }   
    
    return intervals;
  }
  
  public int getLateness() {
    int late = lateness;
    this.lateness = 0;
    
    return late;
  }
  
  public List<Task> sortByDeadline(List<Task> tasks) {
    Collections.sort(tasks, new Comparator<Task>() {
      @Override
      public int compare(Task t1, Task t2) {
        return t1.getDeadline() - t2.getDeadline();
      }
    });
    
    return tasks;
  }
}
