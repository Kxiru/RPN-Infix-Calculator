package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {


  private static final String testString = "This is a string for testing";
  private static final String testString2 = "This is another string for testing";
  private StrStack strStack;

  @BeforeEach // Initialise before each test case:
  public void setup() {
    strStack = new StrStack();
  }

  @Test // Test 1 - Tests whether Stack is empty when initiated.
  void emptyInitialStack() {
    assertEquals(strStack.isEmpty(), true, "The Stack is empty when initiated.");
  }

  @Test // Test 2 - Stack size increases when pushing an item.
  void pushIncreasesSize() {
    assertEquals(strStack.isEmpty(), true,
        "The stack should be empty after pushing a float onto it.");
    strStack.push("Greetings");
    assertEquals(strStack.isEmpty(), false,
        "The stack should no longer be empty after pushing a String onto it.");
    strStack.push("Hello");
    assertEquals(strStack.isEmpty(), false,
        "The stack should no longer be empty after pushing a String onto it.");
  }

  @Test // Test 3 - Tests whether popping an empty stack gives an Empty Stack Exception.
  void emptyInitialStackPop() {
    assertThrows(EmptyStackException.class, () -> strStack.pop(),
        "Unable to pop from an empty stack.");
  }

  @Test // Test 4 - Tests whether Stack Pops.
  void strStackPop() throws BadTypeException {
    strStack.push("This is a test string");
    assertEquals(strStack.pop(), "This is a test string", "The Stack is empty when initiated.");
  }

  @Test // Test 5 - Tests whether Stack Pops the top value.
  void strStackPop2() throws BadTypeException {
    strStack.push(testString);
    assertEquals(strStack.pop(), testString, "The Stack is empty when initiated.");
  }

  @Test // Test 6 - Tests whether Stack Pops multiple values.
  void strStackPopMulti() throws BadTypeException {
    strStack.push(testString2);
    strStack.push(testString);
    assertEquals(strStack.pop(), testString, "The Stack is empty when initiated.");
    assertEquals(strStack.pop(), testString2, "The Stack is empty when initiated.");
  }

  @Test // Test 7 - Tests whether Stack accepts changed strings.

  void toStringTest() throws BadTypeException {
    strStack.push(Integer.toString(2));
    assertEquals(strStack.pop(), "2", "The Stack is empty when initiated.");
  }

  @Test // Test 8 - Tests whether Stack accepts changed strings but more abstracted.

  void toStringTest2() throws BadTypeException {
    String[] strArray = new String[5];
    strArray[2] = "Greetings";
    strStack.push(Double.toString(2.5));
    assertEquals(strStack.pop(), "2.5", "The Stack is empty when initiated.");
    strStack.push(strArray[2]);
    assertEquals(strStack.pop(), "Greetings", "The Stack is empty when initiated.");
  }

  // @Test // Test 9 - Tests whether Stack Pops the top value which is a different type. This test
  // is invalid because StrStack only accepts String input.
  //
  // void strStackPop2() throws BadTypeException {
  // strStack.push(2);
  // assertEquals(strStack.pop(), 2, "The Stack is empty when initiated.");
  // }

}
