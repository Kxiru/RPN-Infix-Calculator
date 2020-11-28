package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestEntry {
  public Entry sum = new Entry("2 2 +");
  public Entry sum2 = new Entry("2 2 +");
  public Entry sum3 = new Entry("2 3 +");
  public Entry sum4 = new Entry(5);
  public Entry sum5 = new Entry(Symbol.PLUS);

  @Test // Test 1 - Tests that an integer is generated through hashCode.
  void hashCodeTest() {
    int sumHash = sum.hashCode();
    System.out.printf(sumHash + "\n");
  }

  @Test // Test 1.5 - Tests that an integer is generated through hashCode when the Entry is an int.
  void intHashCodeTest() {
    int sumHash = sum4.hashCode();
    System.out.printf(sumHash + "\n");
  }

  @Test // Test 2 - Tests that the .equals() method works with, same values and same types.
  void twoEntriesEqualTest() {
    assertEquals(sum.equals(sum2), true, "Sum and Sum2 are equal.");
  }

  @Test // Test 3 - Tests that the .equals() method works with, different values and same types.
  void twoEntriesUnEqualTest() {
    assertEquals(sum.equals(sum3), false, "Sum and Sum3 aren't equal.");
  }

  @Test // Test 4 - Tests that the .equals() method works with, same values and different types.
  void sameValsDiffTypesTest() {
    assertEquals(sum.equals(sum5), false, "Sum and Sum5 aren't equal.");
  }

  @Test
  // Test 5 - Tests that the .equals() method works with, different values and different
  // types.
  void diffValsDiffTypesTest() {
    assertEquals(sum4.equals(sum5), false, "Sum4 and Sum5 aren't equal.");
  }

  @Test
  // Test 6 - Tests type verification.
  void typeVerifyTest() {
    assertEquals(sum.getType(), Type.STRING, "Sum is a string.");
    // System.out.println(sum.getType());
  }

}
