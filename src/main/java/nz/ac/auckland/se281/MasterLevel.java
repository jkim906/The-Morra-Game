package nz.ac.auckland.se281;

public class MasterLevel implements JarvisDifficulty {
  protected Strategy strategy;
  private StoreFingers storeFingers;

  public MasterLevel(StoreFingers storeFingers) {
    this.storeFingers = storeFingers;
    this.strategy = new Random();
  }

  @Override
  public int jarvisFingers() {
    // after round 4 switch from average to top every round
    if ((storeFingers.getRound() == 4) || (strategy instanceof Top)) {
      this.strategy = new Average();
    } else if (strategy instanceof Average) {
      this.strategy = new Top();
    }
    int jarvisSum = strategy.jarvisFingers();
    return jarvisSum;
  }

  @Override
  public int jarvisSum() {
    int jarvisSum = strategy.jarvisSum(storeFingers);
    return jarvisSum;
  }
}
