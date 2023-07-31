package nz.ac.auckland.se281;

public class Average implements Strategy {

  private int jarvisFingers;

  public int jarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    return this.jarvisFingers;
  }

  public int jarvisSum(StoreFingers storeFingers) {
    // find the average in the arraylist in storeFingers
    double sum = 0;
    int avg;
    for (int i = 0; i < storeFingers.getFingerList().size(); i++) {
      sum += storeFingers.getFingerList().get(i);
    }
    avg = (int) Math.round(sum / (double) storeFingers.getFingerList().size());
    int jarvisSum = jarvisFingers + avg;
    return jarvisSum;
  }
}
