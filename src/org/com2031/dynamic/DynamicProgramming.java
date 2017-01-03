package org.com2031.dynamic;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DynamicProgramming {

  public static void main(String[] args) {
    System.out.println("-------------------");
    System.out.println("Dynamic Programming");
    System.out.println("-------------------\n");
    
    System.out.println("Knapsack Problem");
    System.out.println("Picking the optimal items i to fill the knapsack so that the weight w <= weight limit W for the max total value v");
    System.out.println("Time complexity: O(nW) - pseudo-polynomial\n");
    testKnapsack();
    System.out.println("\n");
    
    System.out.println("Sequence Alignment");
    System.out.println("Finding the minumum cost of aligning two strings to be the same with gap penalty δ and mismatch penalty α");
    System.out.println("Time complexity: O(mn)\n");
    testSequenceAlignment();           
    System.out.println("\n");
    
    System.out.println("Weighted Interval Scheduling");
    System.out.println("Computing the optimal interval schedule for maximum total weight");
    System.out.println("Time complexity: O(n log(n))\n");
    testWeightedIntervalScheduling();
    System.out.println("\n");      
  }
  
  public static void testWeightedIntervalScheduling() {
    WeightedJob j1 = new WeightedJob(1,3,2);
    WeightedJob j2 = new WeightedJob(0,4,5);
    WeightedJob j3 = new WeightedJob(3,5,4);
    WeightedJob j4 = new WeightedJob(5,7,2);
    WeightedJob j5 = new WeightedJob(7,9,3);
    WeightedJob j6 = new WeightedJob(8,10,4);
    WeightedJob j7 = new WeightedJob(9,11,1);
    
    List<WeightedJob> jobs = new ArrayList<WeightedJob>(Arrays.asList(j1,j2,j3,j4,j5,j6,j7));
    
    WeightedIntervalScheduling wis = new WeightedIntervalScheduling(jobs);
    
    int[] table = wis.schedule();
    
    System.out.println("Input jobs: " + jobs + "\n");
    
    int[] compatible = wis.getCompatible();
    for(int i = 1; i < table.length; i++) {
      System.out.println("p(" + i + ") = " + compatible[i] +"\tM[" + i + "] = " + table[i]);
    }
    
    System.out.println("\nThe optimal schedule is: " + wis.findSchedule());
    System.out.println("The total weight is: " + table[table.length-1]);
    
  }
  
  public static void testSequenceAlignment() {
    String x = "CTACCG";
    String y = "TACATG";
    SequenceAlignment sa = new SequenceAlignment(x, y);
    
    int result = sa.sequenceAlignment(2, 1);
    
    sa.printTable();
    System.out.println("\nThe minimum cost of aligning " + x + " and " + y + " is: " + result);
  }
  
  public static void testKnapsack() {
    Item id = new Item("dummy",0,0);
    Item i1 = new Item("1",1,1);
    Item i2 = new Item("2",6,2);
    Item i3 = new Item("3",18,5);
    Item i4 = new Item("4",22,6);
    Item i5 = new Item("5",28,7);
    
//    Item a1 = new Item("1",1,1);
//    Item a2 = new Item("2",20,3);
//    Item a3 = new Item("3",9,4);
//    Item a4 = new Item("4",14,8);
//    Item a5 = new Item("5",30,17);
    
    int weightLimit = 11;
    List<Item> items = new ArrayList<Item>(Arrays.asList(id,i1,i2,i3,i4,i5));
    
    Knapsack ks = new Knapsack(weightLimit, items);
    
    ks.initialiseTable();
    ks.knapsackRecursive(items.size()-1, weightLimit);
    int[][] table = ks.getTable();
    
    System.out.println("Recursive - top-down approach");
    ks.printTable();
    
    ks.initialiseTable();
    ks.knapsackIterative();
    table = ks.getTable();
    
    System.out.println("\nIterative - bottom-up approach");
    ks.printTable();    
    
    System.out.println("\nThe max total value is: " + table[items.size()-1][weightLimit]);
    System.out.println("The optimal items for the knapsack are: " + ks.getOPTItems());
  }

}
