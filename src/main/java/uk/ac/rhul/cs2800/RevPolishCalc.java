package uk.ac.rhul.cs2800;

/**
 * Evaluates Reverse Polish String Expressions.
 * 
 * @author Keiru
 */
public class RevPolishCalc implements Calculator {

  NumStack values = new NumStack();

  @Override
  public float evaluate(String what) throws InvalidExpression, BadTypeException {
    String[] operands = what.split(" ");
    float val1;
    float val2;
    float answer;

    // Divide by Zero Errors

    for (int i = 0; i < operands.length; i++) {

      switch (operands[i]) {
        case "+":
          try {
            values.push(values.pop() + values.pop());
          } catch (Exception e) {
            throw new InvalidExpression("Your expression was invalid. Try again.");
          }
          break;

        case "-":
          try {
            val1 = values.pop();
            val2 = values.pop();
            values.push(val2 - val1);
          } catch (Exception e) {
            throw new InvalidExpression("Your expression was invalid. Try again.");
          }
          break;

        case "*":
          try {
            values.push(values.pop() * values.pop());
          } catch (Exception e) {
            throw new InvalidExpression("Your expression was invalid. Try again.");
          }
          break;

        case "/":
          try {
            val1 = values.pop();
            val2 = values.pop();
            values.push(val2 / val1);
          } catch (Exception e) {
            throw new InvalidExpression("Your expression was invalid. Try again.");
          }
          break;

        default:
          try {
            Float.parseFloat(operands[i]);
          } catch (Exception e) {
            throw new InvalidExpression("Your expression was invalid. Try again.");
          }
          values.push(Float.parseFloat(operands[i]));
      }
    }

    answer = values.pop();
    System.out.printf("%f\n", answer);
    return answer;
  }

}
