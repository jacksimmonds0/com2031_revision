package org.com2031.DandC;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DivideAndConquer {

  public static void main(String[] args) {
    System.out.println("2D Minimum Distance");
    System.out.println("Algorithm to find the minimum distance between two points in a 2-dimensional space");
    System.out.println("Time complexity: O(n log^2(n))\n");
    testMinDistance2D();
    System.out.println("\n");
    
    System.out.println("Merge sort");
    System.out.println("Sorting algorithm by splitting the list in two recursively and sorting each list by merging");
    System.out.println("Time complexity: O(n log2(n))\n");
    testMergesort();
    System.out.println("\n");
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
    
    List<Point> points = new ArrayList<Point>();
    points.add(p1);
    points.add(p2);
    points.add(p3);
    points.add(p4);
    points.add(p5);
    points.add(p6);
    points.add(p7);
    points.add(p8);
    points.add(p9);
    
    ClosestPoint2D algorithm = new ClosestPoint2D();
    
    DecimalFormat df = new DecimalFormat("0.00");
    
    System.out.println("Points: " + points);
    System.out.println("No of points: " + points.size());
    
    // initially sort the points by x co-ordinate before performing the algorithm
    points = algorithm.sortByXCoordinate(points);
    System.out.println("The minimum distance within the set of points is: " + 
        df.format(algorithm.minDistance(points)));
  }
  
}
