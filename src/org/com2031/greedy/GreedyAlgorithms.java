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
    
    System.out.println("Scheduled jobs: " + is.intervalScheduling(jobs));
  }
}
