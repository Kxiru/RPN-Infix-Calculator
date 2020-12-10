package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

/**
 * Implements a stack of symbols.
 * @author Keiru
 *
 */
public class OpStack {
  private Stack opStack;

  /**
   * A constructor for the composed class, OpStach. Opstack is a facade that is built using objects
   * from another class (Stack). It addresses operators in the calculator.
   */
  public OpStack() {
    opStack = new Stack();
  }

  /**
   * The Push() method adds entries to the stack. It uses the method from Stack to push the Symbol
   * Type Entry to the stack.
   * 
   * @param i A Symbol (enum) type input that is passed into the stack.
   */
  public void push(Symbol i) {
    opStack.push(new Entry(i));
  }

  /**
   * The Pop() method takes off the top element of the stack. It also returns this value. A Stack
   * uses LIFO (Last in, First Out) implementation. An exception is thrown if the size of the list
   * is zero.
   * 
   * @return Returns the Symbol of the item at the top of the stack.
   * @throws BadTypeException If the type is incorrect / invalid.
   */
  public Symbol pop() throws BadTypeException {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      Entry entry = opStack.pop();
      return entry.getSymbol();
    }
  }

  /**
   * The isEmpty() method validates whether or not the stack is empty.
   * 
   * @return Returns false when the stack is not empty.
   */
  public boolean isEmpty() {
    if (opStack.size() == 0) {
      return true;
    }
    return false;
  }
}
