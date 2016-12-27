package org.com2031.DandC;


public class Point {

  private double x;
  private double y;
  
  public Point(double x, double y) {
    super();
    this.x = x;
    this.y = y;
  }
  
  public double getX() {
    return this.x;
  }
  
  public double getY() {
    return this.y;
  }
  
  @Override
  public String toString() {
    return "(" + this.x + ", " + this.y + ")";
  }
  
}
