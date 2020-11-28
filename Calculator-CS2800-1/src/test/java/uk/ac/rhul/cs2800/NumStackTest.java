package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;
import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {

  private NumStack numStack;

  @BeforeEach // Initialise before each test case:
  public void setup() {
    numStack = new NumStack();
  }

  @Test // Test 1 - Tests whether Stack is empty when initiated.
  void emptyInitialStack() {
    assertEquals(numStack.isEmpty(), true, "The Stack is empty when initiated.");
  }

  @Test // Test 1 - Stack size increases when pushing an item.
  void pushIncreasesSize() {
    assertEquals(numStack.isEmpty(), true,
        "The stack should be empty after pushing a float onto it.");
    numStack.push(0.5f);
    assertEquals(numStack.isEmpty(), false,
        "The stack should no longer be empty after pushing a float onto it.");
    numStack.push(0.5f);
    assertEquals(numStack.isEmpty(), false,
        "The stack should no longer be empty after pushing a float onto it.");
  }

  @Test // Test 3 - Tests whether popping an empty stack gives an Empty Stack Exception.
  void emptyInitialStackPop() {
    assertThrows(EmptyStackException.class, () -> numStack.pop(),
        "Unable to pop from an empty stack.");
  }
  
  @Test // Test 4 - Tests whether Stack Pops.
  void numStackPop() throws BadTypeException {
    numStack.push(0.5f);
    assertEquals(numStack.pop(), 0.5f, "The Stack is empty when initiated.");
  }
  
  @Test // Test 4 - Tests whether Stack Pops the top value.
  void numStackPop2() throws BadTypeException {
    numStack.push(0.75f);
    assertEquals(numStack.pop(), 0.75f, "The Stack is empty when initiated.");
  }
  
  @Test // Test 5 - Tests whether Stack Pops multiple values.
  void numStackPopMulti() throws BadTypeException {
    numStack.push(0.75f);
    numStack.push(0.65f);
    assertEquals(numStack.pop(), 0.65f, "The Stack is empty when initiated.");
    assertEquals(numStack.pop(), 0.75f, "The Stack is empty when initiated.");
  }

}
