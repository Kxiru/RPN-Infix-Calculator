package uk.ac.rhul.cs2800;

/**
 * Evaluates infix string expressions.
 * 
 * @author Keiru
 *
 */
public class StandardCalc implements Calculator {

  StrStack values = new StrStack();
  RevPolishCalc rpCalc = new RevPolishCalc();

  /**
   * Evaluates a string, what, that is provided in infix notation. Returns a float. This method also
   * calls on the RPN calculator as it uses the Shunting algorithm to convert from infix notation to
   * Reverse Polish Notation.
   */
  @Override
  public float evaluate(String what) throws InvalidExpression, BadTypeException {
    // Convert to RPC

    String rpcConverted = "";
    String[] operands = what.split(" ");
    // System.out.println(Arrays.toString(operands));

    for (int i = 0; i < operands.length; ++i) {

      String c = operands[i];

      if (isNumeric(c)) {
        rpcConverted += c + " ";
      } else if (c.equals("(")) {
        values.push(c);
      } else if (c.equals(")")) {
        while (!values.isEmpty() && !values.peek().equals("(")) {
          rpcConverted += values.pop() + " ";
        }
        values.pop();
      } else { // It is assumed that these values are operators
        while (!values.isEmpty() && getPrecedence(c) <= getPrecedence(values.peek())) {
          rpcConverted += values.pop() + " ";
        }
        values.push(c);
      }
    }
    while (!values.isEmpty()) {
      if (values.peek().equals("(")) {
        System.out.println("This expression is invalid");
      }
      rpcConverted += values.pop() + " ";
    }

    System.out.println("RPC is:" + rpcConverted);
    float answer = rpCalc.evaluate(rpcConverted);
    return answer;
  }

  /**
   * Numeric() validates whether the substring contains just numbers.
   * 
   * @param c A substring passed to the method to be validated.
   * @return returns false is the string is not a number.
   */
  private static boolean isNumeric(String c) {
    try {
      Float.parseFloat(c);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * getPrecedence is necessary to decide which order certain expressions should be executed in.
   * 
   * @param ch a string that will be a symbol.
   * @return returns an integer according to the level of precedence.
   */
  static int getPrecedence(String ch) {
    if (ch.equals("+") || ch.equals("-")) {
      return 1;
    } else if (ch.equals("*") || ch.equals("/")) {
      return 2;
    } else {
      return -1;
    }
  }

}
