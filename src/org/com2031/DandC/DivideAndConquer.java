package org.com2031.DandC;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideAndConquer {

  public static void main(String[] args) {
    System.out.println("------------------");
    System.out.println("Divide and Conquer");
    System.out.println("------------------\n");
    
    System.out.println("2D Minimum Distance");
    System.out.println("Algorithm to find the minimum distance between two points in a 2-dimensional space");
    System.out.println("Time complexity: O(n log^2(n))\n");
    testMinDistance2D();
    System.out.println("\n");
    
    System.out.println("Merge sort");
    System.out.println("Sorting algorithm by splitting the list in two recursively and sorting each list by merging");
    System.out.println("Time complexity: O(n log(n))\n");
    testMergesort();
    System.out.println("\n");
    
    System.out.println("Counting Inversions");
    System.out.println("An algorithm to count the number of inversions performed in a list to sort using merge sort");
    System.out.println("Time complexity: O(n log(n))\n");
    testCountingInversions();
    System.out.println("\n");
  }
  
  public static void testCountingInversions() {
    CountingInversions count = new CountingInversions();
    List<Integer> list = new ArrayList<Integer>();

    list.addAll(Arrays.asList(1,5,4,8,10,2,6,9,12,11,3,7));
  
    System.out.println("Unsorted list: " + list);
    System.out.println("No of inversions: " + count.countInversions(list));   
  }
  
  public static void testMergesort() {
    Mergesort mergesort = new Mergesort();
    List<Integer> list = new ArrayList<Integer>();

    // add random integers to the list
    int min = 0;
    int max = 20;
    for(int i  = 0 ; i < max; i++) {
      int randomNum = min + (int)(Math.random() * ((max - min) + 1));
      list.add(randomNum);
    }
    
    System.out.println("Unsorted list: " + list);
    System.out.println("Sorted list: " + mergesort.mergesort(list));
  }

  public static void testMinDistance2D() {
    Point p1 = new Point(10,9);
    Point p2 = new Point(12,-11);
    Point p3 = new Point(-11,8);
    Point p4 = new Point(-6,-7);
    Point p5 = new Point(15,8);
    Point p6 = new Point(14,-10);
    Point p7 = new Point(-5,-4);
    Point p8 = new Point(-9,-6);
    Point p9 = new Point(-10,-5);
    
    List<Point> points = new ArrayList<Point>(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));
    
    ClosestPoint2D cp2D = new ClosestPoint2D();
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    System.out.println("Points: " + points);
    System.out.println("No of points: " + points.size());
    
    // initially sort the points by x co-ordinate before performing the algorithm
    points = cp2D.sortByXCoordinate(points);
    System.out.println("The minimum distance within the set of points is: " + 
        df.format(cp2D.minDistance(points)));
  }
  
}
