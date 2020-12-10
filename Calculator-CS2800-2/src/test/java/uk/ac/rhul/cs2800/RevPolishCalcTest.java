package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RevPolishCalcTest {

  private RevPolishCalc rpCalc;

  @BeforeEach // Initialise before each test case:
  public void setup() {
    rpCalc = new RevPolishCalc();
  }

  // @Test // Test 1 - A test to see whether the class returns.
  // void returnsFloat() throws InvalidExpression {
  // assertEquals(rpCalc.evaluate("Cheese"), 0, "Test if class returns a float;");
  // }

  // @Test // Test 2 - A test to see whether the class returns a float.
  // void returnsFloat2() throws InvalidExpression {
  // assertEquals(rpCalc.evaluate("1.2"), Float.parseFloat("1.2"), "Test if class returns a
  // float;");
  // }

  // @Test // Test 3 - A test to see whether the class throws an exception.
  // void emptyInitialStackPop() throws InvalidExpression {
  // assertThrows(InvalidExpression.class, () -> rpCalc.evaluate(7),
  // "Function can only take String input.");
  // }
  // //The above test did not work because the function only takes strings as input.

  // @Test // Test 4 - I want to use an array in order to parse data. This test ensures the data has
  // // been parsed correctly according to the delimiter " " by counting the amount of elements that
  // // are created from a test string.
  // void delimiterTest() throws InvalidExpression {
  // assertEquals(rpCalc.evaluate("This is a test String"), (float) 5, "Testing with dynamic data");
  // }

  @Test // Test 5 - Testing an RPN string.
  void firstStringTest() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("2 2 +"), (float) (4),
        "The answer to this RPN string should be 4.0");
  }

  @Test // Test 6 - Testing a second RPN string with multiple operators.
  void secondStringTest() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("2 2 2 + *"), (float) (8),
        "The answer to this RPN string should be 8.0");
  }

  // @Test // Test 7 - Testing what happens when an invalid character is used.
  // void invalidCharacterTest() throws InvalidExpression, BadTypeException {
  // assertThrows(NumberFormatException.class, () -> rpCalc.evaluate("4 a +"),
  // "Function can only take alphanumeric input. Without the alpha.");
  // // The RPN that is currently implemented throws an exception when alphabetic input is used. I
  // // wonder why it does not throw any of the exceptions I made, but rather the
  // // NumberFormatException.
  // }

  @Test // Test 8 - Testing what happens when an invalid special character is used.
  void invalidCharacterTest2() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> rpCalc.evaluate("4 a +"),
        "Function can only take alphanumeric input. Without the alpha.");
  }

  @Test // Test 9 - I added a Try-Catch block to catch invalid characters from being passed. This
  // time, I threw a custom exception Let's try this again using a special character.
  void invalidCharacterTest3() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> rpCalc.evaluate("? a +"),
        "Special character used. This is illegal.");
    //
  }

  // @Test // Test 10 - Testing a nice divide by zero.
  // void invalidCalculationTest() throws InvalidExpression, BadTypeException {
  // assertThrows(InvalidExpression.class, () -> rpCalc.evaluate("2 0 /"), "Cannot divide by
  // Zero.");
  // }

  @Test // Test 10.5 - No flukes. Let's try that again with multiple double digits
  void divideByZeroTest() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("2 0 /"), (float) (2), "This should not have an answer.");
  }

  @Test // Test 11 - Since my code delimits using spaces, this should also mean that double digits
  // are already accounted for and should not need any extra parsing.
  void doubleDigitTest() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("22 7 +"), (float) (29),
        "The answer to this RPN string should be 29.");
  }

  @Test // Test 12 - No flukes. Let's try that again with multiple double digits
  void doubleDigitTest2() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("22 17 33 + +"), (float) (72),
        "The answer to this RPN string should be 72.");
  }

  @Test // Test 13 - What happens when an expression is passed without spaces?
  void noSpacesTest() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> rpCalc.evaluate("221733++"),
        "This expression is invalid. That's because it cannot be parsed.");
    // Effectively, this means that any expression without spaces where a number is concatenated
    // with a symbol, will be deemed an invalid expression.
  }

  @Test // Test 14 - I then implemented try catch functions for each of the switch clauses. These
  // will prevent incomplete expressions from breaking the program.
  void incompleteExpressionTest2() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> rpCalc.evaluate("22 +"),
        "This expression is incomplete.");
  }

  @Test // Test 15 - Precedence test
  void precedenceTest() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("2 7 * 3 4 * +"), (float) (26), "Precedence not adhered to");
  }

  @Test // Test 16 - Decimal test
  void decimalTest() throws InvalidExpression, BadTypeException {
    assertEquals(rpCalc.evaluate("2.7 0.3 /"), (float) (9), "Did not parse decimal correctly.");
  }

}
