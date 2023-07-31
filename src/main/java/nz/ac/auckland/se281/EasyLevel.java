package nz.ac.auckland.se281;

public class EasyLevel implements JarvisDifficulty {

  protected Strategy strategy;

  public EasyLevel() {
    this.strategy = new Random();
  }

  @Override
  public int jarvisFingers() {
    int jarvisFingers = strategy.jarvisFingers();
    return jarvisFingers;
  }

  @Override
  public int jarvisSum() {
    int jarvisSum = strategy.jarvisSum(null);
    return jarvisSum;
  }
}
