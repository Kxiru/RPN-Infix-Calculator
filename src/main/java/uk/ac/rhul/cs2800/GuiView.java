package uk.ac.rhul.cs2800;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GuiView extends Application implements ViewInterface {

  public String expression;
  public String answer;
  private volatile static GuiView instance = null;
  public boolean showHelp = false;

  @FXML
  private Button calcButton;

  @FXML
  private RadioButton infixRadio;

  @FXML
  private Label totalField;

  @FXML
  private Button resetButton;

  @FXML
  private TextField inputField;

  @FXML
  private Button helpButton;

  @FXML
  private Label helpLabel;

  @FXML
  void helpButtonPressed(ActionEvent event) {

    if (showHelp == false) {
      helpButton.setText("Help");
      helpLabel.setText(
          "Invalid Expression?\n - Check your Notation. RPN is default! \n- Leave a space after each number!");
      showHelp = true;
    } else {
      helpButton.setText("Hide");
      helpLabel.setText("");
      showHelp = false;
    }
  }

  @Override
  public String getExpression() {
    return inputField.getText();
  }

  @Override
  public void setAnswer(String value) {
    totalField.setText(value);
  }

  @Override
  public void menu() {
    resetButton.setDisable(false);
    calcButton.setDisable(false);
    infixRadio.setDisable(false);
  }

  @FXML
  void initialize() {
    instance = this;
  }

  public synchronized static GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
      while (instance == null) {
      }
    }
    return instance;
  }

  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/GuiView.fxml"));
    Scene scene = new Scene(root, 500, 350);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Your Pocket Calculator");
    primaryStage.show();
  }

  @Override
  public void addCalcObserver(Observer f) {
    // Whenever you see an action, do this.
    System.out.println("Evaluate!");
    calcButton.setOnAction(event -> f.notifyObservers());
  }

  @Override
  public void addResetObserver(Observer f) {
    System.out.println("Reset!");
    resetButton.setOnAction(event -> f.notifyObservers());
  }

  @Override
  public void addExpressionObserver(Observer f) {
    System.out.println("Changed radio!");
    infixRadio.setOnAction(event -> f.notifyObservers());
  }
}
