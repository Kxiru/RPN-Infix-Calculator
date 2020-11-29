package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class StrStack {
  private Stack strStack;

  /**
   * The Shunting algorithm requires reversing an expression in order to evaluate left to right - so
   * we provide a facade to hide details.
   * 
   * <p>A constructor for the composed class, StrStack. StrStack is a facade that is built using
   * objects from another class (Stack). It addresses "strings" in the calculator.
   */
  public StrStack() {
    strStack = new Stack();
  }

  /**
   * The Push() method adds entries to the stack. It uses the method from Stack to push the String
   * to the stack.
   * 
   * @param str A String input that is passed into the stack.
   */
  public void push(String str) {
    strStack.push(new Entry(str));
  }

  /**
   * The Pop() method takes off the top element of the stack. It also returns this value. A Stack
   * uses LIFO (Last in, First Out) implementation. An exception is thrown if the size of the list
   * is zero.
   * 
   * @return Returns the String at the top of the stack.
   * @throws BadTypeException If the type is incorrect / invalid.
   */
  public String pop() throws BadTypeException {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      Entry entry = strStack.pop();
      return entry.getString();
    }
  }

  /**
   * The isEmpty() method validates whether or not the stack is empty.
   * 
   * @return Returns false when the stack is not empty.
   */
  public boolean isEmpty() {
    if (strStack.size() == 0) {
      return true;
    }
    return false;
  }
}
