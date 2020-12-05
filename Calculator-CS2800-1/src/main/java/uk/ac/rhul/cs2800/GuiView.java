package uk.ac.rhul.cs2800;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GuiView {

    @FXML
    private Button calcButton;

    @FXML
    private Label label1;

    @FXML
    void isPressed(ActionEvent event) {
      //Calculate
      label1.setText("I am the answer!");
    }

    @FXML
    void radioButtonPressed(ActionEvent event) {
      //Infix enabled
    }

}
