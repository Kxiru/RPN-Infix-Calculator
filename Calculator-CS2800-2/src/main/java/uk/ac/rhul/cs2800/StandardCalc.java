package uk.ac.rhul.cs2800;

public class StandardCalc implements Calculator {

  StrStack values = new StrStack();
  RevPolishCalc rpCalc = new RevPolishCalc();

  @Override
  public float evaluate(String what) throws InvalidExpression, BadTypeException {
    // Convert to RPC
    String rpcConverted = "";
    what = what.replace(" ", "");

    for (int i = 0; i < what.length(); ++i) {
      String c = Character.toString(what.charAt(i));

      if (alphanumeric(c)) {
        rpcConverted += c;
      } else if (c == "(") {
        values.push(c);
      } else if (c == ")") {
        while (!values.isEmpty() && values.peek() != "(") {
          rpcConverted += values.pop();
        }
      } else {
        while (!values.isEmpty() && getPrecedence(c) <= getPrecedence(values.peek())) {
          rpcConverted += values.pop();
        }
        values.push(c);
      }
    }
    while (!values.isEmpty()) {
      if (values.peek() == "(") {
        System.out.println("This expression is invalid");
        return 0;
      }
      rpcConverted += " " + values.pop();
    }
    // Finally, parse the string so that spaces are consistent
    rpcConverted = rpcConverted.replace(" ", "");
    rpcConverted = rpcConverted.replaceAll(".(?!$)", "$0 ");
    //rpcConverted = rpcConverted.substring(0, rpcConverted.length());

    System.out.println("RPC is:" + rpcConverted);
    float answer = rpCalc.evaluate(rpcConverted);
    return answer;
  }

  private static boolean alphanumeric(String c) {
    char character = c.charAt(0);
    if (((int) character >= 48) && ((int) character <= 57)) {
      return true; // character is a number;
    } else {
      return false;
    }
  }

  static int getPrecedence(String ch) {
    if (ch == "+" || ch == "-") {
      return 1;
    } else if (ch == "*" || ch == "/") {
      return 2;
    } else {
      return -1;
    }
  }

}
