package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  private int numberOfRounds = 1;
  private String username;
  private JarvisDifficulty jarvisDifficulty;
  private DifficultyFactory difficultyFactory = new DifficultyFactory();
  private StoreFingers storeFingers;
  private boolean gameIsRunning = false;
  private int jarvisWins = 0;
  private int playerWins = 0;
  private int pointsToWin;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // When starting a new game, reset the number of rounds, the number of wins of the player and
    // the jarvis, then print the welcome message
    username = options[0];
    numberOfRounds = 1;
    jarvisWins = 0;
    playerWins = 0;
    this.pointsToWin = pointsToWin;
    this.storeFingers = new StoreFingers();
    this.jarvisDifficulty = difficultyFactory.setDifficulty(difficulty, storeFingers);
    MessageCli.WELCOME_PLAYER.printMessage(username);
    gameIsRunning = true;
  }

  public void play() {
    // play only if the game is running
    if (!gameIsRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    } else {
      MessageCli.START_ROUND.printMessage(Integer.toString(numberOfRounds));
      numberOfRounds++;
      MessageCli.ASK_INPUT.printMessage();
      String input = Utils.scanner.nextLine();
      // Split input string on space
      String[] inputArray = input.split(" ");
      // check if inputArray has 2 inputs
      if (inputArray.length == 2) {
        String fingersT = inputArray[0];
        String sumT = inputArray[1];
        // ask user to input again if the input is not valid
        while (checkIfValid(fingersT, sumT) == false) {
          MessageCli.INVALID_INPUT.printMessage();
          MessageCli.ASK_INPUT.printMessage();
          input = Utils.scanner.nextLine();
          inputArray = input.split(" ");
          fingersT = inputArray[0];
          sumT = inputArray[1];
        }
        // change the string into an integer
        int fingers = Integer.parseInt(fingersT);
        int sum = Integer.parseInt(sumT);
        MessageCli.PRINT_INFO_HAND.printMessage(username, inputArray[0], inputArray[1]);
        int jfingers = this.jarvisDifficulty.jarvisFingers();
        int jsum = this.jarvisDifficulty.jarvisSum();
        storeFingers.addFingers(fingers);
        MessageCli.PRINT_INFO_HAND.printMessage(
            "Jarvis", Integer.toString(jfingers), Integer.toString(jsum));
        checkIfWin(fingers, sum, jfingers, jsum);
        // check if the player or the jarvis has won the game
        if (playerWins == pointsToWin) {
          MessageCli.END_GAME.printMessage(username, Integer.toString(storeFingers.getRound()));
          gameIsRunning = false;
        } else if (jarvisWins == pointsToWin) {
          MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(storeFingers.getRound()));
          gameIsRunning = false;
        }
        storeFingers.increaseRound(); // increase the number of rounds
      } else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
  }

  public void showStats() {
    // show stats only if the game is running
    if (!gameIsRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    } else {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          username, Integer.toString(playerWins), Integer.toString(pointsToWin - playerWins));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(jarvisWins), Integer.toString(pointsToWin - jarvisWins));
    }
  }

  private boolean checkIfValid(String fingers, String sum) {

    // check if the input is two integers
    if (Utils.isInteger(fingers) == false
        || Utils.isInteger(sum) == false
        || fingers == null
        || sum == null) {
      return false;
    }
    // check if the input fingers is a positive integer between 1 and 5 and sum is a positive
    // integer between 1 and 10
    if (Integer.parseInt(fingers) >= 1
        && Integer.parseInt(fingers) <= 5
        && Integer.parseInt(sum) >= 1
        && Integer.parseInt(sum) <= 10) {
      return true;
    }
    return false;
  }

  private void checkIfWin(int fingers, int sum, int jarvisFingers, int jarvisSum) {
    // check if the player has won of the jarvis has won, then print the outcome of the round.
    if (sum == (jarvisFingers + fingers) && jarvisSum != (jarvisFingers + fingers)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
      playerWins++; // increase the number of wins of the player
    } else if (sum != (jarvisFingers + fingers) && jarvisSum == (jarvisFingers + fingers)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
      jarvisWins++; // increase the number of wins of the jarvis
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    }
  }
}
