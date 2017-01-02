package org.com2031.dynamic;

import java.util.List;
import java.util.ArrayList;

public class Knapsack {

  /** Declared as final so the weight limit/item count value cannot be changed after initialisation */
  private final int weightLimit;        // W
  private final int itemCount;          // n
  private List<Item> items = null;      // input items i[n]
  private int[][] memoTable = null;     // memoization table
  private List<Item> optItems = null;   // optimal items for solutions

  public Knapsack(int weightLimit, List<Item> items) {
    super();
    this.weightLimit = weightLimit;
    this.items = items;
    this.itemCount = items.size()-1;
    // add 1 to item count/weight limit for zeroth values in table for i and w
    memoTable = new int[itemCount+1][weightLimit+1];
    this.optItems = new ArrayList<Item>();
  }
  
  /**
   * Bottom-up approach as the method starts at the beginning of the memo table - M[0,0]
   */
  public void knapsackIterative() { 
    for(int w = 0; w < weightLimit; w++) {
      memoTable[0][w] = 0;
    }
    
    // loop through the memoization table
    for(int i = 0; i <= itemCount; i++) {
      memoTable[i][0] = 0;
      for(int w = 1; w <= weightLimit; w++) {
        if(i == 0) {
          memoTable[i][w] = 0;
        }
        // if the current item i weight exceeds current w - the item cannot be used
        else if(items.get(i).getWeight() > w) {
          // therefore take the item above i-1 value at weight w
          memoTable[i][w] = memoTable[i-1][w];        
        }
        // otherwise the current item i can be used
        else {
          // check for the max between the item above i-1 or using the current item i
          // when using current item add the value v(i) at take away the weight w(i)
          memoTable[i][w] = Math.max(memoTable[i-1][w], items.get(i).getValue() + memoTable[i-1][w - items.get(i).getWeight()]);
        }
      }
    }   
  }
  
  /**
   * Top-down approach as the method begins at the end of the memo table - M[n,W]
   */
  public int knapsackRecursive(int i, int w) {     
    if(memoTable[i][w] != -1) {
      return memoTable[i][w];
    }
    
    if(i == 0) {
      memoTable[i][w] = 0;
      return 0;
    }
    else if(items.get(i).getWeight() > w) {
      // assign value to the table at each point of recursion to show how the max value was reached
      memoTable[i][w] = knapsackRecursive(i-1, w);
      return memoTable[i][w];
    }
    else {
      memoTable[i][w] = Math.max(knapsackRecursive(i-1, w), items.get(i).getValue() + knapsackRecursive(i-1, w - items.get(i).getWeight()));
      return memoTable[i][w];
    }
  }
  
  public void findOPTItems(int i, int w, int total) {   
    // base case - when the max value is reached in the opt items list
    if(total >= memoTable[itemCount][weightLimit] || i <= 0) {
      // do nothing - all items added and end of recursion
    }
    // if the value above the current are equal
    else if(memoTable[i][w] == memoTable[i-1][w]) {
      // recursively move to the item above
      findOPTItems(i-1, w, total);
    }
    // when value above is not equal
    else {
      // add the current item to the optimal items list
      optItems.add(items.get(i));
      // add that items value to the total for the base case
      total += items.get(i).getValue();
      // recursively move to the item above and back by the weight added to opt items
      findOPTItems(i-1, w - items.get(i).getWeight(), total);
    } 
  }
  
  public void initialiseTable() {
    for(int i = 0; i <= itemCount; i++) {
      for(int w = 0; w <= weightLimit; ++w) {
        memoTable[i][w] = -1;
      }
    }
  }
  
  public int[][] getTable() {
    return this.memoTable;
  }
  
  public List<Item> getOPTItems() {
    // start at the end of the memoization table to find optimal items
    this.findOPTItems(itemCount, weightLimit, 0);
    return this.optItems;
  }
  
  public void printTable() {
    // the table formatting... its not great but what are you gonna do?
    System.out.print("i/W |\t");
    for(int i = 0; i < weightLimit + 1; i++) {
      System.out.print(i + " " + "\t");
    }
    System.out.println();
    
    // print header
    System.out.print("----");
    for(int i = 0; i < weightLimit + 1; i++) {
      System.out.print("--------");
    }
    System.out.println();
    
    for (int i = 0; i < items.size(); i++) {
      for (int j = 0; j < weightLimit+1; j++) {
        if(j == 0) {
          // print row header
          System.out.print(i + "   |\t");
        }
        // print main table
        System.out.print(memoTable[i][j] + " " + "\t");      
      }
      System.out.println();
    }   
  }
}
