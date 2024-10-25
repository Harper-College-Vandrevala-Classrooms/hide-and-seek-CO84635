package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestFuzzyFinder {

  FuzzyFinder finder;
  FuzzyListGenerator generator;

  @BeforeEach
  void setUp() {
    finder = new FuzzyFinder();
    generator = new FuzzyListGenerator();
  }

  @Test
  void exampleFailingTestWithRandomizedFuzzies() {
    ArrayList<Fuzzy> fuzzies = generator.randomizedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }

  @Test
  void exampleFailingTestWithSortedFuzzies() {
    ArrayList<Fuzzy> fuzzies = generator.sortedRainbowFuzzies();
    assertEquals("purple", fuzzies.getFirst().color);
  }

    @Test
    void testLinearSearchWithSortedFuzzies() {
        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        int index = finder.linearSearch(sortedFuzzies, "gold");
        assertNotEquals(-1, index); 
    }

    @Test
    void testBinarySearchWithSortedFuzzies() {
        ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
        int index = finder.binarySearch(sortedFuzzies, "gold");
        assertNotEquals(-1, index); 
    }

    @Test
    void testLinearSearchWithRandomFuzzies() {
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
        int index = finder.linearSearch(randomFuzzies, "gold");
        assertNotEquals(-1, index); 
    }

    @Test
    void testBinarySearchWithRandomFuzzies() {
        ArrayList<Fuzzy> randomFuzzies = generator.randomizedRainbowFuzzies();
        int index = finder.binarySearch(randomFuzzies, "gold");
        assertEquals(-1, index); 
    }

    @Test
    void testEmptyListForLinearSearch() {
      ArrayList<Fuzzy> emptyList = new ArrayList<>();
      int index = finder.linearSearch(emptyList, "gold");
      assertEquals(-1, index);
    }

    @Test
    void testEmptyListForBinarySearch() {
      ArrayList<Fuzzy> emptyList = new ArrayList<>();
      int index = finder.binarySearch(emptyList, "gold");
      assertEquals(-1, index);
    }

    @Test
    void testNonExistentWordInSortedListWithLinear(){
      ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
      int index = finder.linearSearch(sortedFuzzies, "Foo");
      assertEquals(-1, index);
    }

    @Test
    void testNonExistentWordInRandomListWithLinear(){
      ArrayList<Fuzzy> sortedFuzzies = generator.randomizedRainbowFuzzies();
      int index = finder.linearSearch(sortedFuzzies, "Foo");
      assertEquals(-1, index);
    }

    @Test
    void testNonExistentWordInSortedListWithBinary(){
      ArrayList<Fuzzy> sortedFuzzies = generator.sortedRainbowFuzzies();
      int index = finder.binarySearch(sortedFuzzies, "Foo");
      assertEquals(-1, index);
    }

    @Test
    void testNonExistentWordInRandomListWithBinary(){
      ArrayList<Fuzzy> sortedFuzzies = generator.randomizedRainbowFuzzies();
      int index = finder.binarySearch(sortedFuzzies, "Foo");
      assertEquals(-1, index);
    }
}
