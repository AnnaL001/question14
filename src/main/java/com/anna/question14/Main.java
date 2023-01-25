package com.anna.question14;

import com.anna.question14.util.Utility;

import java.util.Arrays;
import java.util.Map;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class Main {
  public static int[] getOccurrenceFrequency(String[] stringList, String[] queries){
    int[] frequencies = new int[queries.length];
    int frequency = 0;
    // Initial sort to allow for binary search
    Arrays.sort(stringList);
    for(int index = 0; index < queries.length; index++){
      // Get frequency of query value
      frequency = performOccurrenceCount(frequency, stringList, queries[index], 0, stringList.length-1);
      frequencies[index] = frequency;
      // Reset frequency for reuse by next query
      frequency = 0;
    }

    return frequencies;
  }

  public static int performOccurrenceCount(int currentCount, String[] stringList, String target, int lowIndex, int highIndex){
    Map<String, Object> searchResult = Utility.binarySearch(stringList, target, lowIndex, highIndex);

    while (parseBoolean(searchResult.get("found").toString())){
      int foundIndex = parseInt(searchResult.get("index").toString());
      // Increment count
      currentCount++;
      // Clear found value
      stringList[foundIndex] = "";
      // Sort after array update to allow for binary search
      Arrays.sort(stringList);
      // Perform binary search again on updated array
      searchResult = Utility.binarySearch(stringList, target, lowIndex, highIndex);
    }

    return currentCount;
  }
  public static void main(String[] args) {
    String[] inputList = {"ab", "ab", "abc"};
    String[] queryList = {"ab", "abc", "bc"};

    String output = Arrays.toString(getOccurrenceFrequency(inputList,queryList));
    System.out.println(output);
  }
}