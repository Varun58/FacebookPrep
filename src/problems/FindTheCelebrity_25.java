package problems;/**
 * // TODO Comment
 */

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Random;

class FindTheCelebrity_25 {

  private int numberOfPeople;

  public int findCelebrity(int n) {
    numberOfPeople = n;
    int celebrityCandidate = 0;
    for (int i = 0; i < n; i++) {
      if (knows(celebrityCandidate, i)) {
        celebrityCandidate = i;
      }
    }

    if (isCelebrity(celebrityCandidate)) {
      return celebrityCandidate;
    }

    return -1;
  }

  private boolean isCelebrity(int i) {
    for (int j = 0; j < numberOfPeople; j++) {
      if (i == j) {
        continue;
      }

      if (knows(i, j) || !knows(j, i)) {
        return false;
      }
    }

    return true;
  }

  // HELPER FUNCTION
  private boolean knows(int x, int y) {
    return new Random().nextBoolean();
  }
}
