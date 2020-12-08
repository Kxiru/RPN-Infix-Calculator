package uk.ac.rhul.cs2800;

public interface ViewInterface {

  void addCalcObserver(Observer f);
  
  void addResetObserver(Observer f);

  void addExpressionObserver(Observer f);

  String getExpression();

  void setAnswer(String str);

  void menu();
}
