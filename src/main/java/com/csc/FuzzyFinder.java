package com.csc;

import java.util.ArrayList;

public class FuzzyFinder {
  public static int binarySearch(ArrayList<Fuzzy> fuzzieStrings, String fuzzieToFind) {
    int low = 0;
    int high = fuzzieStrings.size() - 1;

    while (low <= high){
      int middlePosition = (low + high) / 2;
      int fuzzieComparison = fuzzieToFind.compareTo(fuzzieStrings.get(middlePosition).color);

      if (fuzzieComparison == 0) {
        return middlePosition;
      } else if (fuzzieComparison < 0) {
        high = middlePosition - 1;
      } else {
        low = middlePosition + 1;
      }
    }

    return -1;
  }

  public static int linearSearch(ArrayList<Fuzzy> fuzzieStrings, String fuzzieToFind){
    for (int i = 0; i < fuzzieStrings.size(); i++){
      if(fuzzieStrings.get(i).color.equals(fuzzieToFind)){
          return i;
      }
    }

    return -1;
  }


  public static void main(String args[]) {
  FuzzyListGenerator generator = new FuzzyListGenerator();
  FuzzyFinder finder = new FuzzyFinder();

  ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
  ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();

  String fuzzieToFind = "gold";

  int testOne = finder.linearSearch(sortedFuzzies, fuzzieToFind);
  int testTwo = finder.binarySearch(sortedFuzzies, fuzzieToFind);
  int testThree = finder.linearSearch(randomFuzzies, fuzzieToFind);
  int testFour = finder.binarySearch(randomFuzzies, fuzzieToFind);

  System.out.println("Linear Search in sortedFuzzies: " + testOne);
  System.out.println("Binary Search in sortedFuzzies: " + testTwo);
  System.out.println("Linear Search in randomFuzzies: " + testThree);
  System.out.println("Binary Search in randomFuzzies: " + testFour);
}
}

