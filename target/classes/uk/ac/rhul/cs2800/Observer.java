package uk.ac.rhul.cs2800;

@FunctionalInterface
public interface Observer {
  //Gives the ability to pass in a method as a parameter.
  public void notifyObservers();
}
