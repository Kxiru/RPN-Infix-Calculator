package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack {
  private Stack numStack;

  /**
   * A constructor for the composed class, NumStack. NumStack is a facade that is built using
   * objects from another class (Stack). It addresses floats in the calculator.
   */
  public NumStack() {
    numStack = new Stack();
  }

  /**
   * The Push() method adds entries to the stack. It uses the method from Stack to push the Float
   * Type Entry to the stack.
   * 
   * @param number A float type input that is passed into the stack.
   */
  public void push(Float number) {
    numStack.push(new Entry(number));
  }

  /**
   * The Pop() method takes off the top element of the stack. It also returns this value. A Stack
   * uses LIFO (Last in, First Out) implementation. An exception is thrown if the size of the list
   * is zero.
   * 
   * @return Returns the value of the item at the top of the stack.
   * @throws BadTypeException If the type is incorrect / invalid.
   */
  public float pop() throws BadTypeException {
    if (this.isEmpty()) {
      throw new EmptyStackException();
    } else {
      Entry entry = numStack.pop();
      return entry.getValue();
    }
  }

  /**
   * The isEmpty() method validates whether or not the stack is empty.
   * 
   * @return Returns false when the stack is not empty.
   */
  public boolean isEmpty() {
    if (numStack.size() == 0) {
      return true;
    }
    return false;
  }
}
