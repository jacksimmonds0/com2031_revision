package org.com2031.dynamic;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class DynamicProgramming {

  public static void main(String[] args) {
    System.out.println("Knapsack Problem");
    System.out.println("Picking the optimal items i to fill the knapsack so that the weight w <= weight limit W for the max total value v");
    System.out.println("Time complexity: O(nW) - pseudo-polynomial\n");
    testKnapsack();
    System.out.println("\n");
    
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
