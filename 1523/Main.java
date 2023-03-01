class Main {
  public static void main(String[] args) {

  }

  public int countOdds(int low, int high) {
    return (high - low + 1) / 2 + (low % 2 == 1 && high % 2 == 1 ? 1 : 0);
  }
}