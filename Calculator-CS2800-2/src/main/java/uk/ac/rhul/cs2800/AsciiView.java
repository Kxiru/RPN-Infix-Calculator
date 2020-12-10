package uk.ac.rhul.cs2800;

import java.util.Scanner;

/**
 * The ASCIIView allows for Console use of the Calculator.
 * 
 * @author Keiru
 *
 */
public class AsciiView implements ViewInterface {

  public String expression;
  public String answer;
  boolean infixNotation = false;
  public String curNotation = "Reverse Polish Notation";

  Observer infix = null;
  Observer calc = null;
  Observer reset = null;

  /**
   * getExpression() retrieves the expression from the user to be evaluated.
   */
  @Override
  public String getExpression() {
    return expression;
  }

  /**
   * setAnswer() changes the value of answer to the calculated answer.
   * 
   * @param str sets the answer to str.
   */
  @Override
  public void setAnswer(String str) {
    this.answer = str;
    System.out.printf("Your answer is: %s\n", answer);
  }

  /**
   * menu() creates a console based view of the system.
   */
  @Override
  public void menu() {
    System.out.println("Welcome to Your Pocket Calculator!");
    boolean finished = false;
    Scanner s = new Scanner(System.in);
    Scanner expr = new Scanner(System.in);

    while (!finished) {
      help();
      s = new Scanner(System.in);
      expr = new Scanner(System.in);
      String t = s.next();

      switch (t.toUpperCase().charAt(0)) {
        case 'C':
          System.out.printf("Your current notation is %s\n", curNotation);
          System.out.printf("Please provide your expression:\n");

          expression = expr.nextLine();
          System.out.println("Your expression was: " + expression);
          calc.notifyObservers();
          break;

        case 'R':
          answer = "";
          expression = "";
          System.out.printf("Calculator Reset\n");
          reset.notifyObservers();
          break;

        case 'N':
          System.out
              .printf("Enter \n{I} for Infix Notation or \n{R} for Reverse Polish Notation\n");
          String choice = s.next();
          if (choice.equals("R")) {
            System.out.printf("\nNotation set to Reverse Polish Notation.\n");
            curNotation = "Reverse Polish Notation";
            infixNotation = false;
            break;
          }
          if (choice.equals("I")) {
            System.out.printf("Notation set to Infix.\n");
            curNotation = "Infix Notation";
            infixNotation = true;
            break;
          }
          System.out.printf("Your input was invalid. Returning to Menu.\n");
          infix.notifyObservers();
          break;

        case 'L':
          System.out.printf("Your answer was: %s\n", answer);
          break;

        case 'Q':
          System.out.println("Thank you for using Your Pocket Calculator!");
          finished = true;
          break;

        default:
          help();
      }
    }
    expr.close();
    s.close();
  }

  /**
   * help() lists the ASCII navigation menu.
   */
  private void help() {
    System.out.printf("\n > Please select from one of the following:\n");
    System.out.println("  ----------------------- ");
    System.out.println("  N - to set notation");
    System.out.println("  C - to calculate");
    System.out.println("  R - to reset the calculator");
    System.out.println("  L - to view your last answer ");
    System.out.println("  Q - to exit");
    System.out.println("  ----------------------- ");
  }

  /**
   * This observer listens to evaluate the stored expression.
   */
  @Override
  public void addCalcObserver(Observer f) {
    calc = f;
  }

  /**
   * This observer listens to reset the calculator.
   */
  @Override
  public void addResetObserver(Observer f) {
    reset = f;
  }

  /**
   * This observer listens to return the type of notation that is currently selected.
   */
  @Override
  public void addExpressionObserver(Observer f) {
    infix = f;
  }

}
