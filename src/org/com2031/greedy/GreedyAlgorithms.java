package org.com2031.greedy;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class GreedyAlgorithms {

  public static void main(String[] args) {
    System.out.println("Interval Scheduling");
    System.out.println("Finding the maximum subset of mutually compatible jobs (not overlapping)");
    System.out.println("Time complexity: O(n log(n))\n");
    testIntervalScheduling();
    System.out.println("\n");
    
    System.out.println("Interval Partioning");
    System.out.println("Assinging a schedule to the minimum no of rooms possible, including all jobs input across the rooms");
    System.out.println("Time complexity: O(n log(n))\n");
    testIntervalPartioning();
    System.out.println("\n");
    
    System.out.println("Minimizing Lateness");
    System.out.println("Determining the interval schedule to minimize the lateness given a list of tasks taking duration/time t and for deadline d");
    System.out.println("Time complexity: O(n log(n))\n");
    testMinimizingLateness();
    
  }
  
  public static void testMinimizingLateness() {
    MinimizingLateness ml = new MinimizingLateness();
    
    Task a = new Task(1,9);
    Task b = new Task(3,14);
    Task c = new Task(3,6);
    Task d = new Task(2,8);
    Task e = new Task(2,15);
    Task f = new Task(4,9);
    
    List<Task> tasks = new ArrayList<Task>(Arrays.asList(a,b,c,d,e,f));
    
    System.out.println("Input tasks: " + tasks);
    System.out.println("Intervals result: " + ml.planIntervals(tasks));
    System.out.println("Lateness: " + ml.getLateness());
    
  }
  
  public static void testIntervalPartioning() {
    IntervalPartioning ip = new IntervalPartioning();
    
    Job a = new Job(9,10);
    Job b = new Job(9,12);
    Job c = new Job(9,10);
    Job d = new Job(11,13);
    Job e = new Job(11,15);
    Job f = new Job(14,15);
    Job g = new Job(14,15);
    Job h = new Job(15,17);
    Job i = new Job(16,18);
    Job j = new Job(16,18);
    
    List<Job> jobs = new ArrayList<Job>(Arrays.asList(a,b,c,d,e,f,g,h,i,j));
    
    Object[] rooms = ip.partition(jobs).toArray(); 
    
    System.out.println("Input jobs: " + jobs);
    
    System.out.println("Partioned rooms schedules:");
    for(int z = 0; z < rooms.length; z++) {
      System.out.println(rooms[z]);
    }
  }
  
  public static void testIntervalScheduling() {
    Job a = new Job(0,6);
    Job b = new Job(1,4);
    Job c = new Job(3,5);
    Job d = new Job(3,8);
    Job e = new Job(4,7);
    Job f = new Job(5,9);
    Job g = new Job(6,10);
    Job h = new Job(8,11);
    
    List<Job> jobs = new ArrayList<Job>(Arrays.asList(a,b,c,d,e,f,g,h));
    
    System.out.println("Initial jobs: " + jobs);
    
    IntervalScheduling is = new IntervalScheduling();
    
    System.out.println("Scheduled jobs: " + is.schedule(jobs));
  }
}
