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

/**
 * A graphical window with a text friend for expression, a calculate button and a radio button for
 * determining notation.
 * 
 * @author Keiru
 *
 */
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

  /**
   * When the help button is pressed, a small menu is displayed with some instructions.
   * 
   * @param event passed when the help button is pressed.
   */
  @FXML
  void helpButtonPressed(ActionEvent event) {

    if (showHelp == false) {
      helpButton.setText("Help");
      helpLabel.setText("Invalid Expression?\n - Check your Notation. RPN is default! "
          + "\n- Leave a space after each number!");
      showHelp = true;
    } else {
      helpButton.setText("Hide");
      helpLabel.setText("");
      showHelp = false;
    }
  }

  /**
   * Gets the expression to be evaluated from the text field.
   */
  @Override
  public String getExpression() {
    return inputField.getText();
  }

  /**
   * Sets the answer in the answer field to the evaluated answer.
   */
  @Override
  public void setAnswer(String value) {
    totalField.setText(value);
  }

  /**
   * Calling this function enables all of the buttons in the menu.
   */
  @Override
  public void menu() {
    resetButton.setDisable(false);
    calcButton.setDisable(false);
    infixRadio.setDisable(false);
  }

  /**
   * Initializes the GUIView.
   */
  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * Creates a thread for the GUI View to start.
   * 
   * @return Returns an instance of the GUIView
   */
  public synchronized static GuiView getInstance() {
    if (instance == null) {
      new Thread(() -> Application.launch(GuiView.class)).start();
      while (instance == null) {
      }
    }
    return instance;
  }

  /**
   * Initializes the window and UI. Prepares the GUI.
   */
  public void start(Stage primaryStage) throws Exception {

    Parent root = FXMLLoader.load(getClass().getResource("/GuiView.fxml"));
    Scene scene = new Scene(root, 500, 350);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Your Pocket Calculator");
    primaryStage.show();
  }

  /**
   * Notifies the calculator observer when the calculate button has been pressed.
   */
  @Override
  public void addCalcObserver(Observer f) {
    // Whenever you see an action, do this.
    System.out.println("Evaluate!");
    calcButton.setOnAction(event -> f.notifyObservers());
  }

  /**
   * Notifies the reset observer when the reset button has been pressed.
   */
  @Override
  public void addResetObserver(Observer f) {
    System.out.println("Reset!");
    resetButton.setOnAction(event -> f.notifyObservers());
  }

  /**
   * Notifies the infix observer when the notation radio has been toggled.
   */
  @Override
  public void addExpressionObserver(Observer f) {
    System.out.println("Changed radio!");
    infixRadio.setOnAction(event -> f.notifyObservers());
  }
}
