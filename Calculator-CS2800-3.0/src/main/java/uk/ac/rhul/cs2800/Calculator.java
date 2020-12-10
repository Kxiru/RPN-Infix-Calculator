package uk.ac.rhul.cs2800;

/**
 * A calculator interface for the Reverse Polish Calculator and Infix Calculator.
 * 
 * @author Keiru
 *
 */
public interface Calculator {

  /**
   * Allows calculation of string expressions.
   * 
   * @param what the string to be evaluated.
   * @return returns an answer as a float.
   * @throws InvalidExpression The expression is invalid.
   * @throws BadTypeException The type is bad.
   */
  public float evaluate(String what) throws InvalidExpression, BadTypeException;
}
