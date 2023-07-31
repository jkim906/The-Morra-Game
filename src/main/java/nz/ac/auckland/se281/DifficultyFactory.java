package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class DifficultyFactory {
  // This method is used to set the difficulty of the game
  public JarvisDifficulty setDifficulty(Difficulty difficulty, StoreFingers storeFingers) {
    // return the corresponding difficulty using switch case to check the difficulty
    switch (difficulty) {
      case EASY:
        return new EasyLevel();
      case MEDIUM:
        return new MediumLevel(storeFingers);
      case HARD:
        return new HardLevel(storeFingers);
      case MASTER:
        return new MasterLevel(storeFingers);
      default:
        break;
    }
    return null;
  }
}
