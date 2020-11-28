package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.EmptyStackException;


/**
 * The Stack class that will store Calculator Entries. An ArrayList that takes data of type 'Entry'
 * is used to keep track of the stack.
 * 
 * @author Keiru
 */
public class Stack {
  final static String Id = "$Id$";

  /**
   * This ArrayList stores all of the Entries so that they can be read using RPN from the stack.
   */
  public ArrayList<Entry> list = new ArrayList<Entry>();


  /**
   * This method adds items to the top of the stack.
   * 
   * @param i The value that is being put into the stack. This could be a number or symbol.
   */
  public void push(Entry i) {
    // Adding an Entry to the Stack.
    list.add(i);
  }

  /**
   * The Pop() method takes off the top element of the stack. It also returns this value. A Stack
   * uses LIFO (Last in, First Out) implementation. An exception is thrown if the size of the list
   * is zero.
   * 
   * @return The Entry at the top of the stack.
   */
  public Entry pop() {
    // Taking away the top entry from the stack.
    if (list.size() <= 0) {
      throw new EmptyStackException();
    }
    Entry value = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return value;
  }

  /**
   * The Top() method returns the value at the top of the stack.
   * 
   * @return The value at the top of the stack.
   */
  public Entry top() {
    // Returning the top entry of the stack.
    if (list.size() <= 0) {
      throw new EmptyStackException();
    } else {
      return list.get(list.size() - 1);
    }
  }

  /**
   * The size() method returns the size of the ArrayList Stack.
   * 
   * @return size of stack.
   */
  public int size() {
    // Returning the number of items in the stack.
    return list.size();
  }

}
