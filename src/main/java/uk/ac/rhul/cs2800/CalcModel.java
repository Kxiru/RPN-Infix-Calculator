package uk.ac.rhul.cs2800;

public class CalcModel {
  private float answer = 1;
  private RevPolishCalc revPolish = new RevPolishCalc();
  private StandardCalc standard = new StandardCalc();

  public float evaluate(String expr, boolean isInfix) throws InvalidExpression, BadTypeException{
    if (expr == null || expr.equals("") || expr.equals(" ")) {
      answer = 0;
      return answer;
    }
    if (isInfix) {
      answer = standard.evaluate(expr);
      return answer;
    } else {
      answer = revPolish.evaluate(expr);
      return answer;
    }
  }

  public void reset() {
    answer = 0;
  }

  public String getValue() {
    return String.valueOf(answer);
  }
}
