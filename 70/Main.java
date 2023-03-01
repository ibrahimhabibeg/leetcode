class Main{
  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.climbStairs(5));
  }
  public int climbStairs(int n) {
    if(n==1) return 1;
    if(n==2) return 2;
    int last = 2;
    int beforeLast = 1;
    for (int i = 0; i < n-2; i++) {
      int temp = beforeLast;
      beforeLast = last;
      last+=temp;
    }
    return last;
  }
}