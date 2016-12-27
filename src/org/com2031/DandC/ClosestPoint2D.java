package org.com2031.DandC;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class ClosestPoint2D {
  
  public ClosestPoint2D() {
    super();
  }
  
  public double minDistance(List<Point> currentPoints) {
    double currentMin = 0;
    double sepLine = 0;
    int halfSize = 0;
    List<Point> leftList = null;
    List<Point> rightList = null;
    
    // base cases
    // when there are only two points in the list
    if(currentPoints.size() == 2) {
      return this.euclideanDistance(currentPoints.get(0), currentPoints.get(1));
    }
    // or if the there is only one point in the list
    else if(currentPoints.size() == 1) {
      // return positive infinity so the other side of the list distance will always be smaller
      return Double.POSITIVE_INFINITY;
    }
    
    // split the list differently based on whether the list has an even no of elements or not
    if(currentPoints.size() % 2 == 0) {
      halfSize = currentPoints.size() / 2;
      // define where the separation line is based on the current points list
      sepLine = (currentPoints.get(halfSize).getX() + currentPoints.get(halfSize-1).getX()) / 2;      
    }
    else {
      halfSize = (currentPoints.size() - 1) / 2;
      sepLine = (currentPoints.get(halfSize).getX() + currentPoints.get(halfSize+1).getX()) / 2;
    }
    
    leftList = new ArrayList<Point>(currentPoints.subList(0, halfSize));
    rightList = new ArrayList<Point>(currentPoints.subList(halfSize, currentPoints.size()));

    // divide and conquer - recursively call the method on both sides of the list of points
    double leftDist = minDistance(leftList);
    double rightDist = minDistance(rightList);

    // find the minimum between the two halves of the list
    currentMin = Math.min(leftDist, rightDist);
    
    // delete all points further than the min distance away from the seperation line
    currentPoints = this.deletePointsFromLine(sepLine, currentMin, currentPoints);
    // sort the remaining points by y co-ordinate
    currentPoints = this.sortByYCoordinate(currentPoints);
    
    // all or all but 1 points deleted therefore return current min distance
    if(currentPoints.size() == 0 || currentPoints.size() == 1) {
      return currentMin;
    }
    else {
      // loop through points and compare the adjacent points distances after sorted by Y
      // return the min between that and the current min
      return Math.min(currentMin, this.minFromList(currentPoints));
    }
    
  }
  
  public double minFromList(List<Point> points) {
    double min = 0;
    for(int i = 0; i < points.size() - 1; i++) {
      double dist = this.euclideanDistance(points.get(i), points.get(i + 1));
      if(i == 0) {
        min = dist;
      }
      else if(dist < min) {
        min = dist;
      }
    }
    return min;
  }
  
  public List<Point> deletePointsFromLine(double sepLine, double distance, List<Point> points) { 
    List<Point> tmp = points;
    Iterator<Point> it = tmp.iterator();
    
    while(it.hasNext()) {
      Point pt = it.next();
      if(pt.getX() > sepLine + distance || pt.getX() < sepLine - distance) {
        it.remove();
      }
    }
    
    return tmp;
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
