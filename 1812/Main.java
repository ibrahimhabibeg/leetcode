class Main{
  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.squareIsWhite("h4"));
  }
  public boolean squareIsWhite(String coordinates) {
    return ((coordinates.charAt(0)-'a')+(coordinates.charAt(1)-'0'))%2==0;      
  }
}