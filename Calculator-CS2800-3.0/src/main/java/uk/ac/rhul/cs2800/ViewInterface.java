package uk.ac.rhul.cs2800;

/**
 * View Interface allows calculation of string expressions.
 * @author keiru
 *
 */
public interface ViewInterface {

  /**
   * Adds a Calculator observer to the system.
   * @param f An Observer.
   */
  void addCalcObserver(Observer f);
  
  /**
   * Adds a Reset observer to the system.
   * @param f An Observer.
   */
  void addResetObserver(Observer f);

  /**
   * Adds an Expression observer to the system.
   * @param f An Observer.
   */
  void addExpressionObserver(Observer f);

  /**
   * Returns a string expression.
   * @return returns a String expression.
   */
  String getExpression();

  /**
   * Sets the answer field to the evaluated answer.
   * @param str the evaluated answer to which the answer field should be set.
   */
  void setAnswer(String str);

  /**
   * Called to display the main menus of either calculator (GUI/ASCII).
   */
  void menu();
}
