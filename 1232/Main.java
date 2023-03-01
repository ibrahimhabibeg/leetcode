class Main {
  public static void main(String[] args) {
    int[][] coordinates = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 6, 7 } };
    Main main = new Main();
    System.out.println(main.checkStraightLine(coordinates));
  }

  public boolean checkStraightLine(int[][] coordinates) {
    int deltaX = coordinates[1][0] - coordinates[0][0];
    int deltaY = coordinates[1][1] - coordinates[0][1];
    if (deltaX == 0) {
      for (int i = 2; i < coordinates.length; i++) {
        if (coordinates[i][0] != coordinates[0][0]) {
          return false;
        }
      }
      return true;
    }
    if (deltaY == 0) {
      for (int i = 2; i < coordinates.length; i++) {
        if (coordinates[i][1] != coordinates[0][1]) {
          return false;
        }
      }
      return true;
    }
    double slope = deltaY / deltaX;
    for (int i = 2; i < coordinates.length; i++) {
      int currentDeltaX = coordinates[i][0] - coordinates[i - 1][0];
      int currentDeltaY = coordinates[i][1] - coordinates[i - 1][1];
      if (currentDeltaX == 0 || currentDeltaY == 0 || slope != currentDeltaY / currentDeltaX) {
        return false;
      }
    }
    return true;
  }
}