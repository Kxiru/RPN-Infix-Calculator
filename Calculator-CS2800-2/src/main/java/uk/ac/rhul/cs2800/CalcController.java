package uk.ac.rhul.cs2800;

public class CalcController {
  private ViewInterface myView;
  private CalcModel myModel;
  private boolean isInfix = false;;

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

  public void handleReset() {
    myModel.reset();
    myView.setAnswer(myModel.getValue());
  }

  public void handleExpression() {
    if (isInfix) {
      isInfix = false;
    } else {
      isInfix = true;
    }
  }

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
