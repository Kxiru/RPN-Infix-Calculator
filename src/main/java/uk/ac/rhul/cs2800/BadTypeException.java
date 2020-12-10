package uk.ac.rhul.cs2800;

/**
 * BadTypeException called when an Entry is resolved to the wrong type.
 * 
 * @author Keiru
 */
public class BadTypeException extends Exception {

  /**
   * BadTypeException called when an Entry is resolved to the wrong type.
   */
  private static final long serialVersionUID = 1L;

  public BadTypeException() {}

  /**
   * BadTypeException method when passing a string.
   * 
   * @param message Inherits the methods from Exception for printing an explanatory string.
   */
  public BadTypeException(String message) {
    super(message);
  }
}
