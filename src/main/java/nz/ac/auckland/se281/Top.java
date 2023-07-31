package nz.ac.auckland.se281;

public class Top implements Strategy {
  private int jarvisFingers;

  public int jarvisFingers() {
    this.jarvisFingers = Utils.getRandomNumber(1, 5);
    return this.jarvisFingers;
  }

  public int jarvisSum(StoreFingers storeFingers) {
    // return the most frequent value number stored in the arraylist
    int[] count = new int[6];
    for (int i = 0; i < storeFingers.getFingerList().size(); i++) {
      count[storeFingers.getFingerList().get(i)]++;
    }
    int max = 0;
    int maxIndex = 0;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > max) {
        max = count[i];
        maxIndex = i;
      }
    }
    int jarvisSum = jarvisFingers + maxIndex;
    return jarvisSum;
  }
}
