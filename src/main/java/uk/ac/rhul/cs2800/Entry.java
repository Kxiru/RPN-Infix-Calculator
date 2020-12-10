package uk.ac.rhul.cs2800;

/**
 * This class processes input into their different types.
 * 
 * @author Keiru
 *
 */
public class Entry {
  private float number;
  private String str;
  private Type type;
  private Symbol other;

  /**
   * Constructor for NUMBER type Entry.
   * 
   * @param value A float value.
   */
  public Entry(float value) {
    this.type = Type.NUMBER;
    this.number = value;
  }

  /**
   * Constructor for SYMBOL type Entry.
   * 
   * @param which A Symbol Enum value.
   */
  public Entry(Symbol which) {
    this.type = Type.SYMBOL;
    this.other = which;
  }


  /**
   * Constructor for STRING type Entry.
   * 
   * @param expression A String value.
   */
  public Entry(String expression) {
    this.type = Type.STRING;
    this.str = expression;
  }


  /**
   * A getter for the type of value in the entry.
   * 
   * @return Returns the type of value in the entry.
   */
  public Type getType() {
    return this.type;
  }

  /**
   * A Getter for the String in the Entry. An Exception is thrown if the type does not match.
   * 
   * @return Returns the string in the Entry.
   * @throws BadTypeException An Exception thrown if the type comparison is invalid.
   */
  public String getString() throws BadTypeException {
    if (this.getType() != Type.STRING) {
      throw new BadTypeException("This Entry is not of a valid type.");
    }
    return str;
  }

  /**
   * A Getter for the Symbol in the Entry. An Exception is thrown if the type does not match.
   * 
   * @return Returns the symbol in the entry.
   * @throws BadTypeException An Exception thrown if the type comparison is invalid.
   */
  public Symbol getSymbol() throws BadTypeException {
    if (this.getType() != Type.SYMBOL) {
      throw new BadTypeException("This Entry is not of a valid type.");
    }
    return other;
  }


  /**
   * A getter for the float value in the Entry. An Exception is thrown if the type does not match.
   * 
   * @return Returns the float value in the Entry.
   * @throws BadTypeException An Exception thrown if the type comparison is invalid.
   */
  public float getValue() throws BadTypeException {
    if (this.getType() != Type.NUMBER) {
      throw new BadTypeException("This Entry is not of a valid type.");
    }
    return number;
  }


  /**
   * This method deduces whether the Entry is equal to another entry. This method implements
   * hashCode().
   * 
   * @param entry2 The second entry to compare the first entry to.
   * @return Returns a boolean value. True if the two Entries are equal, and false if they are not.
   */
  public boolean equals(Entry entry2) {
    // 'this' entry will be compared to entry2 by hashCode and type.
    if ((this.getType() == entry2.getType()) && (this.hashCode() == entry2.hashCode())) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method computes a unique hashCode for each individual entry. These hashCodes can determine
   * whether two Entries are the same or not.
   * 
   * @return Returns an integer corresponding to the hashValue of the entry.
   */
  @Override
  public int hashCode() {
    // Different hash functions are applied to different data types.
    int hashValue = 17;
    switch (this.type) {
      case NUMBER:
        hashValue = 31 + 7
            + (int) (Double.doubleToLongBits(number) ^ (Double.doubleToLongBits(number) >>> 32));
        break;
      case STRING:
        hashValue = hashValue + str.hashCode() * str.length();
        break;
      case SYMBOL:
        hashValue += other.hashCode();
        break;
      default:
        hashValue = hashValue + 23 + (other.hashCode() % 7);
        break;
    }
    return hashValue;
  }


}
