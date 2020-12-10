package uk.ac.rhul.cs2800;

public class InvalidExpression extends Exception {
  /**
   * InvalidExpression passed when a non-String is passed.
   */
  private static final long serialVersionUID = 1L;

  public InvalidExpression() {}

  /**
   * String presented if passed with a string.
   * 
   * @param message Inherits the methods from Exception for printing an explanatory string.
   */
  public InvalidExpression(String message) {
    super(message);
  }
}
