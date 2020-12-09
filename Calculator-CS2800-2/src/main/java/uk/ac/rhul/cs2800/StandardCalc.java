package uk.ac.rhul.cs2800;

public class StandardCalc implements Calculator {

  StrStack values = new StrStack();
  RevPolishCalc rpCalc = new RevPolishCalc();

  @Override
  public float evaluate(String what) throws InvalidExpression, BadTypeException {
    // Convert to RPC
    
    String rpcConverted = "";
    // what = what.replace(" ", "");
    String[] operands = what.split(" ");

    for (int i = 0; i < operands.length; ++i) {
      // String c = Character.toString(what.charAt(i));
      
      String c = operands[i];

      if (isNumeric(c)) {
        rpcConverted += c;
      } else if (c.equals("(")) {
        values.push(c);
      } else if (c.equals(")")) {
        while (!values.isEmpty() && !values.peek().equals("(")) {
          rpcConverted += values.pop();
        }
        values.pop();
      } else { // It is assumed that these values are operators
        while (!values.isEmpty() && getPrecedence(c) <= getPrecedence(values.peek())) {
          rpcConverted += values.pop();
        }
        values.push(c);
      }
    }
    while (!values.isEmpty()) {
      if (values.peek().equals("(")) {
        System.out.println("This expression is invalid");
      }
      rpcConverted += values.pop();
    }

    // Finally, parse the string so that spaces are consistent
    rpcConverted = rpcConverted.replace(" ", "");
    rpcConverted = rpcConverted.replaceAll(".(?!$)", "$0 "); //After every character, put a space.

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
      Integer.parseInt(c);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

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
