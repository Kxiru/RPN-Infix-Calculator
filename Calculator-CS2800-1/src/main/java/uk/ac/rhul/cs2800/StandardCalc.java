package uk.ac.rhul.cs2800;

public class StandardCalc implements Calculator {
  
  OpStack values = new OpStack();
  RevPolishCalc rpCalc = new RevPolishCalc();

  @Override
  public float evaluate(String what) throws InvalidExpression {
    return 0;
  }

}
