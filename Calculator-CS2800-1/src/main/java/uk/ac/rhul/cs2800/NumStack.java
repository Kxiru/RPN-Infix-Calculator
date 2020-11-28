package uk.ac.rhul.cs2800;

import java.util.EmptyStackException;

public class NumStack {
  private Stack numStack;
  
  public NumStack() {
    numStack = new Stack();
  }
  
  public void push(Float number) {
    numStack.push(new Entry(number));
  }
  
  public float pop() throws BadTypeException{
    if(this.isEmpty()) {
      throw new EmptyStackException();
    } else {
    Entry entry = numStack.pop();
    return entry.getValue();
    }
  }
  
  public boolean isEmpty() {
    if(numStack.size() == 0) {
      return true;
    }
    return false;
  }
}
