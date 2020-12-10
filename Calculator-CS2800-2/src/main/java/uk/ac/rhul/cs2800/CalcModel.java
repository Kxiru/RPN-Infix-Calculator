package uk.ac.rhul.cs2800;

/**
 * A CalcModel is created to decouple GUIView and ASCIIView.
 * 
 * @author Keiru
 *
 */
public class CalcModel {
  private float answer = 1;
  private RevPolishCalc revPolish = new RevPolishCalc();
  private StandardCalc standard = new StandardCalc();

  /**
   * The evaluate string chooses the type of notation to use and evaluates the string accordingly by
   * calling the appropriate functions.
   * 
   * @param expr The expression to be evaluated.
   * @param isInfix The type of notation to be used.
   * @return returns the evaluated answer.
   * @throws InvalidExpression The expression is invalid.
   * @throws BadTypeException The type is bad.
   */
  public float evaluate(String expr, boolean isInfix) throws InvalidExpression, BadTypeException {
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

  /**
   * Resets the calculator and answer to zero.
   */
  public void reset() {
    answer = 0;
  }

  /**
   * Gets the value of the answer.
   * 
   * @return returns the answer.
   */
  public String getValue() {
    return String.valueOf(answer);
  }
}
