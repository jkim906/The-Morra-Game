package nz.ac.auckland.se281;

import java.util.ArrayList;

public class StoreFingers {

  private ArrayList<Integer> fingerList = new ArrayList<Integer>();
  private int round = 1;

  public void addFingers(int fingers) {
    fingerList.add(fingers);
  }

  public void increaseRound() {
    this.round++;
  }

  public int getRound() {
    return round;
  }

  public ArrayList<Integer> getFingerList() {
    return fingerList;
  }
}
