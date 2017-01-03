package org.com2031.dynamic;


public class SequenceAlignment {

  private char[] x = null;
  private char[] y = null;
  private int[][] costTable = null;
  
  public SequenceAlignment(String stringX, String stringY) {
    super();
    // convert the input strings to compare to char arrays on object construction
    this.x = stringX.toCharArray();
    this.y = stringY.toCharArray(); 
    this.costTable = new int[x.length+1][y.length+1];
  }
  
  /**
   * @param gapPenalty = δ
   * @param mismatchPenalty = α
   */
  public int sequenceAlignment(int gapPenalty, int mismatchPenalty) {
    costTable[0][0] = 0;
    
    // set the the zeroth element in each of x and y to δ*(index)
    for(int i = 1; i <= x.length; i++) { 
      costTable[i][0] = i*gapPenalty;
    }
    
    for(int j = 1; j <= y.length; j++) {
      costTable[0][j] = j*gapPenalty;
    }
    
    for(int i = 1; i <= x.length; i++) {
      for(int j = 1; j <= y.length; j++) {
        // set the value in the table to the minimum of:
        // α[i,j] + M[i-1,j-1]
        // δ + M[i-1,j]
        // δ + M[i,j-1]
        costTable[i][j] = Math.min(matchPenalty(x[i-1], y[j-1], mismatchPenalty) + costTable[i-1][j-1], 
            Math.min(gapPenalty + costTable[i-1][j], gapPenalty + costTable[i][j-1]));
      }
    }
    
    // return the minimum cost of alignment
    return costTable[x.length][y.length];
  }
  
  private int matchPenalty(char x, char y, int mismatchPenalty) {
    // if the characters are the same return 0, otherwise return mismatch penalty
    return (x == y) ? 0 : mismatchPenalty;
  }
  
  public void printTable() {
    
    System.out.print("x/y |\t-\t");
    for(int i = 0; i < y.length; i++) {
      System.out.print(y[i] + " " + "\t");
    }
    System.out.println();
    
    // print header
    System.out.print("----");
    for(int i = 0; i < y.length+1; i++) {
      System.out.print("--------");
    }
    System.out.print("\n-");
    
    for (int i = 0; i <= x.length; i++) {
      for (int j = 0; j <= y.length; j++) {
        if(i == 0 && j == 0) {
          System.out.print("   |\t");
        }
        else if(j == 0) {
          // print row header
          System.out.print(x[i-1] + "   |\t");
        }
        // print main table
        System.out.print(costTable[i][j] + " " + "\t");      
      }
      System.out.println();
    }   
  }
  
}
