package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OpStackTest {

  private OpStack opStack;

  @BeforeEach // Initialise before each test case:
  public void setup() {
    opStack = new OpStack();
  }

  @Test // Test 1 - Tests whether Stack is empty when initiated.
  void emptyInitialStack() {
    assertEquals(opStack.isEmpty(), true, "The Stack is empty when initiated.");
  }

  @Test // Test 2 - Stack size increases when pushing an item onto it.
  void pushIncreasesSize() {
    assertEquals(opStack.isEmpty(), true,
        "The stack should be empty after pushing a float onto it.");
    opStack.push(Symbol.PLUS);
    assertEquals(opStack.isEmpty(), false,
        "The stack should no longer be empty after pushing a Symbol onto it.");
    opStack.push(Symbol.DIVIDE);
    assertEquals(opStack.isEmpty(), false,
        "The stack should no longer be empty after pushing a Symbol onto it.");
  }

  @Test // Test 3 - Tests whether popping an empty stack gives an Empty Stack Exception.
  void emptyInitialStackPop() {
    assertThrows(EmptyStackException.class, () -> opStack.pop(),
        "Unable to pop from an empty stack.");
  }

  @Test // Test 4 - Tests whether Stack Pops.
  void opStackPop() throws BadTypeException {
    opStack.push(Symbol.MINUS);
    assertEquals(opStack.pop(), Symbol.MINUS, "The Stack is empty when initiated.");
  }

  @Test // Test 5 - Tests whether Stack Pops the top value.
  void opStackPop2() throws BadTypeException {
    opStack.push(Symbol.MINUS);
    assertEquals(opStack.pop(), Symbol.MINUS, "The Stack is empty when initiated.");
  }

  @Test // Test 6 - Tests whether Stack Pops multiple values.
  void opStackPopMulti() throws BadTypeException {
    opStack.push(Symbol.LEFT_BRACKET);
    opStack.push(Symbol.MINUS);
    assertEquals(opStack.pop(), Symbol.MINUS, "The Stack is empty when initiated.");
    assertEquals(opStack.pop(), Symbol.LEFT_BRACKET, "The Stack is empty when initiated.");
  }

  // @Test // Test 7 - Tests whether Stack accepts an invalid Symbol. However I can not do this test
  // because Symbol.CHEESE itself is not a valid field.

  // void invalidSymbolTest() throws BadTypeException {
  // opStack.push(Symbol.Cheese);
  // assertEquals(opStack.pop(), Symbol.Cheese, "The Stack is empty when initiated.");
  // }

  // @Test // Test 8 - Tests whether Stack Pops the top value which is a different type. This test
  // is also invalid because OpStack only accepts Symbol input.

  // void opStackPop2() throws BadTypeException {
  // opStack.push("Hello");
  // assertEquals(opStack.pop(), "Hello", "The Stack is empty when initiated.");
  // }

}
