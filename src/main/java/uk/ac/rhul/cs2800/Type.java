package uk.ac.rhul.cs2800;

/**
 * Enumerated Types to discern the type of input. The input could be a number, Symbol, String or it
 * could be invalid.
 * 
 * @author Keiru
 *
 */
public enum Type {
  NUMBER, SYMBOL, STRING, INVALID;


  /**
   * The toString() method allows for the type to be displayed in console.
   */
  @Override
  public String toString() {
    return this.name();
  }

}
