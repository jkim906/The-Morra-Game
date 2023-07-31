package nz.ac.auckland.se281;

public class HardLevel implements JarvisDifficulty {
  protected Strategy strategy;
  protected StoreFingers storeFingers;

  public HardLevel(StoreFingers storeFingers) {
    this.storeFingers = storeFingers;
    this.strategy = new Random();
  }

  @Override
  public int jarvisFingers() {
    if (storeFingers.getRound() >= 4) {
      this.strategy = new Top();
    }
    int jarvisFingers = strategy.jarvisFingers();
    return jarvisFingers;
  }

  @Override
  public int jarvisSum() {
    int jarvisSum = strategy.jarvisSum(storeFingers);
    return jarvisSum;
  }
}
