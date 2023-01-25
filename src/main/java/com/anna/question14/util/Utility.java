package com.anna.question14.util;

import java.util.HashMap;
import java.util.Map;

public class Utility {
  public static Map<String,Object> binarySearch(String[] stringList, String target, int lowIndex, int highIndex){
    Map<String,Object> foundData = new HashMap<>();

    //Define base case that terminates recursion
    if (lowIndex > highIndex){
      foundData.put("found", Boolean.FALSE); // Empty interval; no match
      return foundData;
    } else {
      // Define recursive case
      int midIndex = (lowIndex + highIndex) / 2;
      if (target.compareTo(stringList[midIndex]) == 0){
        foundData.put("found", Boolean.TRUE);
        foundData.put("index", midIndex); // Capture index where value is found
        return foundData;
      } else if (target.compareTo(stringList[midIndex]) < 0){
        return binarySearch(stringList, target, lowIndex, midIndex - 1);
      } else {
        return binarySearch(stringList, target, midIndex + 1, highIndex);
      }
    }
  }
}
