class Main{
  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.trailingZeroes(47));
  }
  ////////////////////////////////////////////////
  /////////////      WRONG         ///////////////
  ////////////////////////////////////////////////
  public int trailingZeroes(int n) {
    int power = (int) (Math.log10(n)/Math.log10(5));
    if(power==0) return 0;
    int ans = 0;
    for (int i = 0; i < power-1; i++) {
      ans+=4*(i+1);
    }
    int i = (int) (n/Math.pow(5, power));
    return ans + i*power;
  }
}