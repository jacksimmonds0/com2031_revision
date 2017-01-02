package org.com2031.dynamic;


public class Item {

  private String name = null;
  private int value  = 0;
  private int weight = 0;
  
  public Item(String name, int value, int weight) {
    super();
    this.name = name;
    this.value = value;
    this.weight = weight;
  }
  
  public String getName() {
    return this.name;
  }
  
  public int getValue() {
    return this.value;
  }
  
  public int getWeight() {
    return this.weight;
  }
  
  @Override
  public String toString() {
    return "(" + this.name + ": v = " + this.value + ", w = " + this.weight + ")";
  }
}
