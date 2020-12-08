package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class AsciiView implements ViewInterface {

  public String expression;
  public String answer;
  boolean infixNotation = false;
  
  Observer infix = null;
  Observer calc = null;
  Observer reset = null;

  @Override
  public String getExpression() {
    return null;
  }

  @Override
  public void setAnswer(String str) {
    this.answer = str;
    System.out.printf("Your answer is: %s", answer);
  }

  /**
   * A menu / console based view.
   */
  @Override
  public void menu() {
    Scanner s = new Scanner(System.in);
    boolean finished = false;
    help();

    while (!finished && s.hasNext()) {
      String t = s.next();
      switch (t.toUpperCase().charAt(0)) {
        case 'C':



          break;
        case 'R':
          break;
        case 'N':
          System.out.printf("Enter \n{I} for Infix Notation or \n{R} for Reverse Polish Notation");
          if (s.next().toUpperCase().charAt(0) == 'R') {
            System.out.println("Notation set to Reverse Polish Notation.");
            infixNotation = false;
          } else if (s.next().toUpperCase().charAt(0) == 'I') {
            System.out.println("Notation set to Infix.");
            infixNotation = true;
          } else {
            System.out.printf("Your input was invalid. Returning to Menu.");
          }
          break;
        case 'Q':
          System.out.println("Bye");
          finished = true;
          break;
        default:
          help();
      }
    }
    s.close();
  }

  private void help() {
    System.out.println("Use one of the following:");
    System.out.println("  N - to set notation");
    System.out.println("  C - to calculate");
    System.out.println("  R - to reset the calculator");
    System.out.println("  Q - to exit");
  }

  @Override
  public void addCalcObserver(Observer f) {
    calc = f;
  }

  @Override
  public void addResetObserver(Observer f) {
    reset = f;
  }

  @Override
  public void addExpressionObserver(Observer f) {
    infix = f;
  }

}
