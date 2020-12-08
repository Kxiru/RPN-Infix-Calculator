package uk.ac.rhul.cs2800;

public class CalcController {
  private ViewInterface myView;
  private CalcModel myModel;
  private boolean isInfix = false;;

  public void handleCalculation() throws InvalidExpression, BadTypeException{
    String userInput = myView.getExpression();
    myModel.evaluate(userInput, isInfix);
    myView.setAnswer(myModel.getValue());
  }

  public void handleReset() {
    myModel.reset();
    myView.setAnswer(myModel.getValue());
  }
  
  public void handleExpression() {
    if(isInfix) {
      isInfix = false;
    } else {
      isInfix = true;
    }
  }

  CalcController(CalcModel model, ViewInterface view){
    myModel = model;
    myView = view;
    
    view.addCalcObserver(() -> {
      try {
        handleCalculation();
      } catch (InvalidExpression e) {
        e.printStackTrace();
      } catch (BadTypeException e) {
        e.printStackTrace();
      }
    });
    view.addResetObserver(this::handleReset);
    view.addExpressionObserver(this::handleExpression);
  }

}