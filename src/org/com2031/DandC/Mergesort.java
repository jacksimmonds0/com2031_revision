package org.com2031.DandC;

import java.util.ArrayList;
import java.util.List;

public class Mergesort {

  public Mergesort() {
    super();
  }

  public List<Integer> mergesort(List<Integer> list) {
    int halfSize = 0;
    List<Integer> leftList = null;
    List<Integer> rightList = null;
    
    // base case
    // when the list only contains one element
    if(list.size() == 1) {
      return list;
    }
    // recursive step
    // divide by splitting the list in half
    else {
      // split list differently if even number of elements or not
      if(list.size() % 2 == 0) {
        halfSize =  list.size() / 2;
      }
      else {
        halfSize = (list.size() + 1) / 2;
      }
      
      leftList = new ArrayList<Integer>(list.subList(0, halfSize));
      rightList = new ArrayList<Integer>(list.subList(halfSize, list.size())); 
      
      // conquer by recursively calling the method to split the lists
      leftList = mergesort(leftList);
      rightList = mergesort(rightList);
      
      // combine the two lists by merging them
      return this.mergeLists(leftList, rightList);
    }
  }

  public List<Integer> mergeLists(List<Integer> leftList, List<Integer> rightList) {
    // uses temporary array to store the merged result from the two input lists
    List<Integer> tmp = new ArrayList<Integer>();
    int totalSize = leftList.size() + rightList.size();

    for(int i = 0; i < totalSize; i++) {
      // check if either list is empty - if so add the element from the other list and remove
      if(leftList.isEmpty()) {
        tmp.add(rightList.get(0));
        rightList.remove(0);
      }
      else if(rightList.isEmpty()) {
        tmp.add(leftList.get(0));
        leftList.remove(0);
      }
      else {
        // otherwise check which first element in each list is bigger and remove (like a stack)
        if(leftList.get(0) < rightList.get(0)) {
          tmp.add(leftList.get(0));
          leftList.remove(0);
        }
        else if(leftList.get(0) > rightList.get(0)) {
          tmp.add(rightList.get(0));
          rightList.remove(0);
        }
        else {
          // if the first elements are equal just arbitrarily take the left element
          tmp.add(leftList.get(0));
          leftList.remove(0);
        }
      }
      
    }

    return tmp;
  }
  
}
