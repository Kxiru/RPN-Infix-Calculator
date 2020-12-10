package uk.ac.rhul.cs2800;

/**
 * The Symbol Enumerated types allow us to differentiate the character / operator being input.
 * 
 * @author Keiru
 *
 */
public enum Symbol {
  LEFT_BRACKET, RIGHT_BRACKET, TIMES, DIVIDE, PLUS, MINUS, INVALID;

  /**
   * The toString() method allows for the type to be displayed in console.
   */
  @Override
  public String toString() {
    return this.name();
  }


}
