package uk.ac.rhul.cs2800;

/**
 * A functional interface for creating Observers.
 * @author Keiru
 *
 */
@FunctionalInterface
public interface Observer {
  /**
   * Notifies observers to act. Gives the ability to pass in a method as a parameter.
   */
  public void notifyObservers();
}
