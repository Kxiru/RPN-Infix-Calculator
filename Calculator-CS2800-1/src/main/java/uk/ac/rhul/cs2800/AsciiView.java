package uk.ac.rhul.cs2800;

import java.util.Scanner;

public class AsciiView implements ViewInterface {
  
  public String expression;
  public String answer;

  @Override
  public String getExpression() {
    return null;
  }

  @Override
  public void setAnswer(String str) {
    this.answer = str;
    System.out.printf("Your answer is: %s", answer);
  }

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

}
