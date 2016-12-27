package org.com2031.DandC;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ClosestPoint2D {
  
  public ClosestPoint2D() {
    super();
  }
  
  
  public List<Point> sortByXCoordinate(List<Point> points) {
    Collections.sort(points, new Comparator<Point>() {
      @Override
      public int compare(Point p1, Point p2) {
          return (int) (p1.getX() - p2.getX());
      }
    });
    
    return points;
  }
  
  public List<Point> sortByYCoordinate(List<Point> points) {
    Collections.sort(points, new Comparator<Point>() {
      @Override
      public int compare(Point p1, Point p2) {
          return (int) (p1.getY() - p2.getY());
      }
    });
    
    return points;
  }

  public double euclideanDistance(Point pt1, Point pt2) {
    double dist = 0;
    dist = Math.sqrt(Math.pow((pt1.getX() - pt2.getX()), 2) + 
        Math.pow((pt1.getY() - pt2.getY()), 2)); 
    
    return dist;
  }
}
