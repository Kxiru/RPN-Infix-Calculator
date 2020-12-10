package uk.ac.rhul.cs2800;

/**
 * The Driver class creates some objects and makes them work nicely, then begins the program.
 * 
 * @author Keiru
 */
public class Driver {

  public static void main(String[] args) {

    ViewInterface view = new AsciiView();

    CalcModel model = new CalcModel();

    if (System.console() == null) {
      System.out.println("GUI View!");
      view = GuiView.getInstance();
    }

    new CalcController(model, view);

    // Switch on buttons
    view.menu();

  }


}
