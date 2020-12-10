package uk.ac.rhul.cs2800;

/**
 * CalcController creates views and models. Adds itself as an observer to the view so that
 * asynchronous changes can be observed.
 * 
 * @author Keiru
 *
 */
public class CalcController {
  private ViewInterface myView;
  private CalcModel myModel;
  private boolean isInfix = false;

  /**
   * handleCalculation() catches exceptions and evaluates expressions.
   * 
   * @throws InvalidExpression The expression is invalid.
   * @throws BadTypeException The type is invalid.
   */
  public void handleCalculation() throws InvalidExpression, BadTypeException {
    try {
      String userInput = myView.getExpression();
      myModel.evaluate(userInput, isInfix);

      if (myModel.getValue().equals("Infinity")) {
        myView.setAnswer("Cannot Divide by Zero!");
      } else {
        myView.setAnswer(myModel.getValue());
      }

    } catch (Exception e) {
      myView.setAnswer("Invalid Expression");
    }
  }

  /**
   * Is notified when a request for a calculator is called.
   */
  public void handleReset() {
    myModel.reset();
    myView.setAnswer(myModel.getValue());
  }

  /**
   * Is notified when a calculation is required.
   */
  public void handleExpression() {
    if (isInfix) {
      isInfix = false;
    } else {
      isInfix = true;
    }
  }

  /**
   * CalcController is a constructor that creates the interface given certain parameters.
   * 
   * @param model The type of calculator. Infix / Reverse Polish Notation.
   * @param view The type of interface. GUI / ASCII view.
   */
  CalcController(CalcModel model, ViewInterface view) {
    myModel = model;
    myView = view;

    view.addCalcObserver(() -> {
      try {
        handleCalculation();
      } catch (InvalidExpression e) {
        System.out.println("Something went wrong!");
      } catch (BadTypeException e) {
        System.out.println("Something went wrong!");
      }
    });
    view.addResetObserver(this::handleReset);
    view.addExpressionObserver(this::handleExpression);
  }

}
