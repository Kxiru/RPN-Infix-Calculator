package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GuiView implements ViewInterface {
  
  public String expression;
  public String answer;

  @FXML
  private Button calcButton;

  @FXML
  private Label label1;

  @FXML
  void isPressed(ActionEvent event) { // Calculate
    label1.setText("I am the answer!");
  }

  @FXML
  void radioButtonPressed(ActionEvent event) { // Infix enabled
  }

  @Override
  public String getExpression() {
    return null;
  }

  @Override
  public void setAnswer(String str) {
    this.answer = str;
    System.out.printf("Your answer is: %s", answer);

  }

}
