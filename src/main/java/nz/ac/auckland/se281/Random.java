package nz.ac.auckland.se281;

public class Random implements Strategy {
  private int jarvisFingers;

  public int jarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    System.out.println(jarvisFingers);
    return this.jarvisFingers;
  }

  public int jarvisSum(StoreFingers storeFingers) {
    int min = jarvisFingers + 1;
    int max = jarvisFingers + 5;
    return Utils.getRandomNumber(min, max);
  }
}
