package org.com2031.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class IntervalPartioning {

  public IntervalPartioning() {
    super();
  }
  
  public PriorityQueue<Room> partition(List<Job> jobs) {
    // sort the input jobs by start time
    jobs = this.sortByStartTime(jobs);
    
    // initialise the rooms where the jobs will be allocated to
    // priority queue to keep running time down
    PriorityQueue<Room> rooms = new PriorityQueue<Room>();
    
    for(int j = 0; j < jobs.size(); j++) {
      // if rooms list is empty add the first job in the list to the first room
      if(rooms.isEmpty()) {
        Room room = new Room(rooms.size()+1);
        room.addJob(jobs.get(j));
        rooms.add(room);
      }
      // check if job j is compatible with some room k schedule
      else if(rooms.peek().getJobs().get(rooms.peek().getJobs().size()-1).getEndTime() <= jobs.get(j).getStartTime()) {       
        // add the current job j to the room k at the top of the queue

        // remove the top element in the queue into a new object
        Room room = rooms.poll();
        // add the current job j to the schedule from the element above
        room.addJob(jobs.get(j));
        // re-add the element back to the queue to re-order the priority queue correctly
        rooms.add(room);
      }
      // otherwise create a new room object and add the current job
      else {
        Room room = new Room(rooms.size()+1);
        room.addJob(jobs.get(j));
        rooms.add(room);
      }
    }
    
    return rooms;
  }
  
  public List<Job> sortByStartTime(List<Job> jobs) {
    Collections.sort(jobs, new Comparator<Job>() {
      @Override
      public int compare(Job j1, Job j2) {
        return j1.getStartTime() - j2.getStartTime();
      }
    });
    
    return jobs;
  }
  
}
