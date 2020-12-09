package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StandardCalcTest {

  private StandardCalc stand;

  @BeforeEach // Initialise before each test case:
  public void setup() {
    stand = new StandardCalc();
  }

  // @Test // Test 1 - Test that Standard Calc effectively shunted after implementation
  // void shuntingReturned(){
  // assertEquals(stand.stringEvaluate("2+5"), (String) ("25+"),
  // "Temporary function stringEvaluate should return proper evaluation.");
  // }

//  @Test // Test 2 - Successfully converted to rpn and was calculated.
//  void calculationtest() throws InvalidExpression, BadTypeException {
//    assertEquals(stand.evaluate("2+2"), (float) (4), "The answer to this RPN string should be 4.0");
//  }
  
  @Test // Test 2 - Successfully converted to rpn and was calculated.
  void calculationtest() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> stand.evaluate("2+2"),
        "Characters in expressions should be separated by spaces");}

  @Test // Test 3 - Test with spaces!
  void calculationtest2() throws InvalidExpression, BadTypeException {
    assertEquals(stand.evaluate(" 2 + 5 "), (float) (7),
        "The answer to this RPN string should be 7.0");
  }

  @Test // Test 4 - Test with Double digits!
  void doubleDigittest2() throws InvalidExpression, BadTypeException {
    assertEquals(stand.evaluate(" 22 + 5 "), (float) (27),
        "The answer to this RPN string should be 27.0");
  }

  @Test // Test 5 - Test with brackets.
  void bracketstest() throws InvalidExpression, BadTypeException {
    assertEquals(stand.evaluate("( 2 + 5 ) + 3"), (float) (10),
        "The answer to this RPN string should be 10.0");
  }
  
  @Test // Test 6 - Test with brackets and no spaces.
  void noSpaceBracketstest() throws InvalidExpression, BadTypeException {
    assertThrows(InvalidExpression.class, () -> stand.evaluate("(2+2)"),
        "Characters in expressions should be separated by spaces");
  }
  
  @Test // Test 7 - Precedence test
  void precedencetest() throws InvalidExpression, BadTypeException {
    assertEquals(stand.evaluate("2 * 7 + 3 * 4 "), (float) (26), "Precedence not adhered to");
  }

}
