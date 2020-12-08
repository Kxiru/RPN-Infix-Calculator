package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStack {

  private Stack calcStack;

  @BeforeEach // Initialise before each test case:
  public void setup() {
    calcStack = new Stack();
  }

  // @Test // Test No.1 - A class was created as a result of this test.
  // void createClassTest() {
  // dataStack calcStack = new dataStack();
  // }

  // @Test // Test No.2 - A method that returned an integer was created.
  // void returnSizeTest() {
  // assertEquals(calcStack.size(), 0, "Test a newly created stack to see that it has size zero");
  // }

  // @Test // Test No.3 - The push method was created, and size++ was added to the code to test that
  // it incremented.
  // void pushSizeTest() {
  // calcStack.push(5);
  // assertEquals(calcStack.size(), 1, "Test whether the size of the stack increases.");
  // }

  // @Test // Test No.4 - Size was made to be zero, and a clause was added stating that if size was
  // zero when pop() was attempted, then an exception should be returned.
  // void emptyPopTest() {
  // assertThrows(EmptyStackException.class, () -> calcStack.pop(),
  // "Unable to pop from an empty stack.");
  // }

  // @Test // Test No.5 - At this point, I implemented an ArrayList and used Arraylist methods to
  // return the latest values. This test was to verify the size of the array given pushing then
  // popping, and also verify whether an exception would be thrown if popped once more.
  // void pushThenPopTest() {
  // calcStack.push(5);
  // assertEquals(calcStack.pop(), 5, "Should pop off a 5");
  // assertEquals(calcStack.size(), 0, "Size of the list should return 0 after popping.");
  // assertThrows(EmptyStackException.class, () -> calcStack.pop(),
  // "Popping after popping should throw an exception");
  // }

  // @Test // Test No.6 - Two items were pushed onto the stack. This test was to ensure that the
  // implementation for reading and then removing Entries, worked.
  // void pushTwiceTest() {
  // calcStack.push(5);
  // calcStack.push(8);
  // assertEquals(calcStack.pop(), 8, "Pop once should return an 8");
  // assertEquals(calcStack.pop(), 5, "Pop twice should return a 5");
  // assertEquals(calcStack.size(), 0, "Size should now be zero");
  // assertThrows(EmptyStackException.class, () -> calcStack.pop(),
  // "Should throw an exception if attempted to pop again");
  // }

  // @Test // Test No.7 - Reworked another verification after making a large number of changes to
  // the ArrayList and it's implementation.
  // void pushThenPopTest() {
  // calcStack.push(5);
  // assertEquals(calcStack.pop(), 5, "Should pop off a 5");
  // assertEquals(calcStack.size(), 0, "Size of the list should return 0 after popping.");
  // assertThrows(EmptyStackException.class, () -> calcStack.pop(),
  // "Popping after popping should throw an EmptyStackException.");
  // }

  // @Test // Test No.8 - Creating the Top() method. This read the first element in the stack but
  // does NOT remove it. To confirm this, 2 values are pushed onto the stack before being read and
  // removed.
  // void implementingTopTest() {
  // calcStack.push(19);
  // calcStack.push(27);
  // assertEquals(calcStack.top(),27,"The top of the stack should be 27");
  // assertEquals(calcStack.pop(), 27, "Should pop off a 27");
  // assertEquals(calcStack.size(), 1, "Size of the list should return 1 after popping.");
  // calcStack.pop();
  // assertEquals(calcStack.size(), 0, "Size of the list should return 0 after popping.");
  // assertThrows(EmptyStackException.class, () -> calcStack.pop(),
  // "Popping after popping should throw an EmptyStackException.");
  // }

  // @Test // Test No.9 - I initially made the top() return 0 if the stack was empty.
  // void topWhenEmptyTest() {
  // calcStack.push(5);
  // assertEquals(calcStack.top(), 5, "Top should be 5");
  // calcStack.pop();
  // assertEquals(calcStack.size(), 0, "Size of the list should return 0 after popping.");
  // assertEquals(calcStack.top(),0,"When attempting to get the top of an empty list, return 0");
  // }

  // @Test // Test No.10 - Pushed many numbers onto the stack to test whether the code works with
  // big(ger) data.
  // void pushManyNumbers() {
  // for(int i=0;i<1000;i++) {
  // calcStack.push(i);
  // }
  // assertEquals(calcStack.top(), 999, "Top should be 999");
  // assertEquals(calcStack.size(), 1000, "There should now be 1000 items in the stack.");
  // calcStack.pop();
  // assertEquals(calcStack.size(), 999, "There should now be 999 items in the stack.");
  // }

  // After all tests worked, I changed the ArrayList type to Entry.

  @Test
  // Test No.11 - Testing whether the stack returns the EmptyStackException if top() is
  // attempted on an empty stack.
  void topWhenEmptyTest2() {
    Entry sum = new Entry("73+");
    calcStack.push(sum);
    assertEquals(calcStack.top(), sum, "Top should be the 'sum' entry");
    calcStack.pop();
    assertEquals(calcStack.size(), 0, "Size of the list should return 0 after popping.");
    assertThrows(EmptyStackException.class, () -> calcStack.top(),
        "When attempting to get the top of an empty list, return 0");
  }

  @Test // Test No.12 - Testing that push(), pop(), top() and size() work as expected.
  void testingToStringOfEntry() {
    Entry sum = new Entry("73+");
    Entry sum2 = new Entry("73-");
    calcStack.push(sum);
    calcStack.push(sum2);
    assertEquals(calcStack.top(), sum2, "Top should be the 'sum2' entry");
    calcStack.pop();
    assertEquals(calcStack.size(), 1, "Size of the list should return 1 after popping.");
    assertEquals(calcStack.pop(), sum, "Popping off sum.");
    assertEquals(calcStack.size(), 0, "Size of the list should return 0 after popping.");
    assertThrows(EmptyStackException.class, () -> calcStack.top(),
        "When attempting to get the top of an empty list, return 0");
  }


}
