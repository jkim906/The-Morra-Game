package nz.ac.auckland.se281;

public class MediumLevel implements JarvisDifficulty {

  protected Strategy strategy;
  private StoreFingers storeFingers;

  public MediumLevel(StoreFingers storeFingers) {
    this.storeFingers = storeFingers;
    this.strategy = new Random();
  }

  @Override
  public int jarvisFingers() {
    if (storeFingers.getRound() >= 4) {
      this.strategy = new Average();
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
